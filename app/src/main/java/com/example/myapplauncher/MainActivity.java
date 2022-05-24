package com.example.myapplauncher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);


        Button confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int choiceId = radioGroup.getCheckedRadioButtonId();
                if (choiceId == -1) {
                    Toast toast = Toast.makeText(getApplicationContext(), "No choice to confirm", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    RadioButton radioButton = findViewById(choiceId);
                    String choice = radioButton.getText().toString();
                    startSecondActivity(choice);
                }

            }
        });
    }

    public void startSecondActivity(String choice) {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("choice", choice);
        startActivity(intent);
    }

}