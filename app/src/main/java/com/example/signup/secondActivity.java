package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        Intent intent = getIntent();
        String input = intent.getStringExtra("ip");
        String input2 = intent.getStringExtra("ip2");
        String radio = intent.getStringExtra("radio");

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.tvName);
        TextView textView1 = findViewById(R.id.textView2);
        TextView textView2 = findViewById(R.id.textView3);
        textView.setText(input);
        textView1.setText(input2);
        textView2.setText(radio);

    }
}