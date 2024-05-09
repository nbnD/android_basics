package com.flutterjunction.fragments_demo;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    private TextView textView;
    private Button button;
    private Fragment2Listener listener;

    public interface Fragment2Listener {
        void onFragment2ButtonClick();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_layout, container, false);
        textView = view.findViewById(R.id.text_view);
        button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onFragment2ButtonClick();
                textView.setText("");
            }
        });

        return view;
    }

    public void updateTextView(String text) {
        textView.setText(text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Fragment2Listener) {
            listener = (Fragment2Listener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement Fragment2Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}

