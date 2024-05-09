package com.flutterjunction.fragments_demo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    private EditText editText;
    private Button button;
    private Fragment1Listener listener;

    public interface Fragment1Listener {
        void onFragment1ButtonClick(String text);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        editText = view.findViewById(R.id.edit_text);
        button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString().trim();
                if (!text.isEmpty()) {
                    listener.onFragment1ButtonClick(text);
                }
            }
        });
        return view;
    }

    public void resetEditText() {
        editText.setText("");

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Fragment1Listener) {
            listener = (Fragment1Listener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement Fragment1Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}

