package com.example.quizappkz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int finalAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String resAddingCorrect(boolean q1_1false, boolean q1_2true, boolean q1_3false,
                                    boolean q2_1true, boolean q2_2false, boolean q2_3false,
                                    boolean q3_1false, boolean q3_2false, boolean q3_3true,
                                    boolean q5_1correct, boolean q5_2incorrect,
                                    boolean q5_3incorrect, boolean q5_4correct, boolean q5_5incorrect,
                                    String textQ4) {

        StringBuilder stringAnswer = new StringBuilder(300);
        // Q1
        if (q1_2true) {
            finalAnswer += 1;
            stringAnswer.append(" 9th is correct!\n");
        } else if (q1_1false) {
            stringAnswer.append("15th is incorrect\n");
        } else if (q1_3false) {
            stringAnswer.append("20th is incorrect\n");
        }

        //Q2
        if (q2_1true) {
            finalAnswer += 1;
            stringAnswer.append("apple is correct!\n");
        } else if (q2_2false) {
            stringAnswer.append("banana is incorrect\n");
        } else if (q2_3false) {
            stringAnswer.append("mango is incorrect\n");
        }

        //Q3
        if (q3_3true) {
            finalAnswer += 1;
            stringAnswer.append("1991 is correct!\n");
        } else if (q3_1false) {
            stringAnswer.append("1954 is incorrect!\n");
        } else if (q3_2false) {
            stringAnswer.append("2001 is incorrect!\n");
        }

        //Q4
        if (textQ4.equals("tenge")) {
            finalAnswer += 1;
            stringAnswer.append("tenge is correct!\n");
        } else {
            stringAnswer.append(textQ4);
            stringAnswer.append(" is not correct\n");
        }

        //Q5

        if (q5_1correct && q5_4correct && !q5_2incorrect && !q5_3incorrect && !q5_5incorrect){
            finalAnswer += 2;
            stringAnswer.append("Astana and Almaty are correct!\n");
        }else{
            stringAnswer.append("Answer for Q5 is incorrect\n");
        }

        String finScoreShow = "Your final score is " + finalAnswer;
        stringAnswer.append(finScoreShow);

        finalAnswer = 0;// Reset grade counter after every button click
        return stringAnswer.toString();
    }


    public void showAnswer(View view) {

        //Q1
        RadioButton q1_1Wrong = findViewById(R.id.q1_1false);
        boolean q1_1false = q1_1Wrong.isChecked();

        RadioButton q1_2Correct = findViewById(R.id.q1_2true);
        boolean q1_2true = q1_2Correct.isChecked();

        RadioButton q1_3Wrong = findViewById(R.id.q1_3false);
        boolean q1_3false = q1_3Wrong.isChecked();

        //Q2
        RadioButton q2_1Correct = findViewById(R.id.q2_1true);
        boolean q2_1true = q2_1Correct.isChecked();

        RadioButton q2_2Wrong = findViewById(R.id.Q2_2false);
        boolean q2_2false = q2_2Wrong.isChecked();

        RadioButton q2_3Wrong = findViewById(R.id.q2_3false);
        boolean q2_3false = q2_3Wrong.isChecked();

        //Q3
        RadioButton q3_1Wrong = findViewById(R.id.q3_1false);
        boolean q3_1false = q3_1Wrong.isChecked();

        RadioButton q3_2Wrong = findViewById(R.id.q3_2false);
        boolean q3_2false = q3_2Wrong.isChecked();

        RadioButton q3_3Correct = findViewById(R.id.q3_3true);
        boolean q3_3true = q3_3Correct.isChecked();

        //Q4
        EditText ansTextQ4 = findViewById(R.id.q4answerEntered);
        String textQ4 = ansTextQ4.getText().toString();

        //Q5
        CheckBox q5_1Correct = findViewById(R.id.Q5_Correct1);
        boolean q5_1true = q5_1Correct.isChecked();

        CheckBox q5_2Incorrect = findViewById(R.id.Q5_Incorrect1);
        boolean q5_2false = q5_2Incorrect.isChecked();

        CheckBox q5_3Incorrect = findViewById(R.id.Q5_Incorrect2);
        boolean q5_3false = q5_3Incorrect.isChecked();

        CheckBox q5_4Correct = findViewById(R.id.Q5_Correct2);
        boolean q5_4true = q5_4Correct.isChecked();

        CheckBox q5_5Incorrect = findViewById(R.id.Q5_Incorrect3);
        boolean q5_5false = q5_5Incorrect.isChecked();

        String finalResult = resAddingCorrect(
                q1_1false, q1_2true, q1_3false,
                q2_1true, q2_2false, q2_3false,
                q3_1false, q3_2false, q3_3true,
                q5_1true, q5_2false, q5_3false,
                q5_4true, q5_5false, textQ4);

        Toast.makeText(this, " \nResult" + finalResult, Toast.LENGTH_LONG).show();


    }


}
