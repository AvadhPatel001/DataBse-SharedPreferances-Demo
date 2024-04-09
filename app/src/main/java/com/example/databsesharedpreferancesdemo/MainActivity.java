package com.example.databsesharedpreferancesdemo;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editTextText);
        textView = findViewById(R.id.textView);

        SharedPreferences sp = getSharedPreferences("KeyOfData", MODE_PRIVATE);
        String def = sp.getString("name", "No Data is hear...");
        textView.setText(def);



        button.setOnClickListener(v -> {
            String val = editText.getText().toString();
            SharedPreferences sp1 = getSharedPreferences("KeyOfData", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp1.edit();
            editor.putString("name", val);
            editor.apply();
            textView.setText(val);
        });
    }
}