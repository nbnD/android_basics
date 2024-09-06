package com.flutterjunction.async_task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        progressBar = findViewById(R.id.progressBar);

        // Execute the background task using AsyncTask
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                myAsyncTask.execute("https://reqres.in/api/users?page=2");
            }
        }, 1000);
    }

    private class MyAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            // Perform any setup or UI updates before the background task starts
            // For example, showing a progress bar
            // This method runs on the UI thread
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {
            // Perform background network operation
            String url = params[0];
            Log.d("URL", "" + url);
            String result = "";

            try {

                result = fetchDataFromNetwork(url);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            // Update UI with the result obtained from background operation
            // This method runs on the UI thread
            resultTextView.setText(result);

            // Perform any cleanup or UI updates after the background task completes
            // For example, hiding the progress bar
            progressBar.setVisibility(View.GONE);
        }

        private String fetchDataFromNetwork(String url) throws IOException {
            // Simulate network request using HttpURLConnection
            // In a real scenario, you would use appropriate libraries or frameworks for network operations
            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("GET");

            StringBuilder response = new StringBuilder();
            try {
                urlObj = new URL(url);
                connection = (HttpURLConnection) urlObj.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }

            // Return the fetched data as a string
            return response.toString();
        }
    }
}
