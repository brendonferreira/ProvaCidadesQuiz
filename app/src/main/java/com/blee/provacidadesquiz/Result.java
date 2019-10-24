package com.blee.provacidadesquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle b = getIntent().getExtras();

        TextView view = findViewById(R.id.result);
        view.setText( "Você fez "+ b.getInt("result") + " pontos!" );
    }
}
