package com.example.android.notereadingquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score;
    String question1Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {
        gradeQuestion1(null);
        gradeQuestion3(null);
        gradeQuestion2(null);
        gradeQuestion4(null);

        String message = "You got " + Integer.toString(score) + " out of 5 correct!";
        Toast.makeText(getApplicationContext(),
                message, Toast.LENGTH_SHORT).show();

        score = 0;

    }

    public void gradeQuestion1(View view) {
        RadioGroup question1RadioGroup = (RadioGroup) findViewById(R.id.question1_radiogroup);
        int selectedId = question1RadioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);

        String selectedAnswer = selectedRadioButton.getText().toString();
        if (selectedAnswer.matches("Half note")) {
            score += 1;
        }
    }

    public void gradeQuestion2(View view) {
        EditText question2TextView = (EditText) findViewById(R.id.question2_input);
        String question2Answer = question2TextView.getText().toString().toUpperCase();

        if (question2Answer.matches("D")) {
            score += 1;
        }
    }

    public void gradeQuestion3(View view) {
        CheckBox halfNote = (CheckBox) findViewById(R.id.question3b_checkbox);
        boolean hasCorrectAnswer1 = halfNote.isChecked();

        CheckBox wholeNote = (CheckBox) findViewById(R.id.question3c_checkbox);
        boolean hasCorrectAnswer2 = wholeNote.isChecked();

        if (hasCorrectAnswer1) {
            score += 1;
        }

        if (hasCorrectAnswer2) {
            score += 1;
        }
    }

    public void gradeQuestion4(View view) {
        RadioGroup question1RadioGroup = (RadioGroup) findViewById(R.id.question4_radiogroup);
        int selectedId = question1RadioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);

        String selectedAnswer = selectedRadioButton.getText().toString();
        if (selectedAnswer.matches("Bass clef")) {
            score += 1;
        }
    }

}
