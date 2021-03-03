package com.example.sharedprefs_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.edTxt);
        Button button = findViewById(R.id.btn_save);

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        editText.setText(preferences.getString("myText", ""));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("myText", editText.getText().toString());
                editor.commit();
            }
        });
    }
}