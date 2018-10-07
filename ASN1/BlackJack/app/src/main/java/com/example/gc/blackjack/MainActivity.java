package com.example.gc.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button hiButton = findViewById(R.id.newgame);
        hiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGameActivity();
            }
        });
    }
    public void openGameActivity() {
        System.out.println("hereere");
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
