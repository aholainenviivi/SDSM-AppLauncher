package com.example.myapplauncher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URL;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView verdictTextView = findViewById(R.id.verdictTextView);
        String choice = getIntent().getExtras().get("choice").toString();
        System.out.println(choice);
        if (choice.equals("Cats")) {
            verdictTextView.setText("Correct.");
        } else if (choice.equals("Dogs")) {
            verdictTextView.setText("Understandable, but wrong.");
        } else {
            verdictTextView.setText("It's something weird like opossums, right?");
        }

        Button showPicsButton = findViewById(R.id.showPicsButton);
        showPicsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String URLString = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
                Uri webPage = Uri.parse(URLString);
                Intent showPics = new Intent(Intent.ACTION_VIEW, webPage);
                try {
                    startActivity(showPics);
                    verdictTextView.setText("Sorry not sorry.");
                } catch (ActivityNotFoundException e) {
                    System.out.println("Cannot open the web page");
                }
            }
        });

    }
}