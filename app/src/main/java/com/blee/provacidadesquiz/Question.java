package com.blee.provacidadesquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question extends AppCompatActivity {
    Quiz quiz;
    ImageView imageView;
    RadioGroup radioGroup;
    private int plays = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        imageView = findViewById(R.id.imageView);
        radioGroup = findViewById(R.id.radiogroup);

                for (City city : Quiz.getCities()) {
                    RadioButton rdbtn = new RadioButton(this);
                    rdbtn.setId(city.resourceImage);
                    rdbtn.setText(city.name);
                    radioGroup.addView(rdbtn);
                }


        quiz = new Quiz( this );
        quiz.next();


    }

    public void setQuizQuestion(City question) {
        imageView.setImageResource( question.resourceImage );
        radioGroup.clearCheck();
    }

    String getAnswer() {
        int buttonId = radioGroup.getCheckedRadioButtonId();
        System.out.println(buttonId);
        RadioButton radio = (RadioButton) findViewById(buttonId);
        return radio.getText().toString();
    }

    public void answerQuiz( View view ) {

        plays++;

        if( quiz.isAnswerRight( getAnswer() ) ) {
            quiz.punctuate();
        } else {
            Toast.makeText(view.getContext(), "A cidade correta era " + quiz.cidadeSorteada.name , Toast.LENGTH_SHORT).show();
        }


        if( plays > 3 ) {
            Intent it = new Intent( view.getContext(), Result.class );
            it.putExtra("result", quiz.pontos);
            startActivity(it);

            return;
        }

        quiz.next();
    }

}
