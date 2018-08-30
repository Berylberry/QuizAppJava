package com.example.nit_appdev_002.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Integer score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public void submitAnswers(View view){
        score = 0;
        RadioGroup firstRadioGroup = findViewById(R.id.first_radio_group);
        Integer firstAnswer = firstRadioGroup.getCheckedRadioButtonId();
        RadioGroup secondRadioGroup = findViewById(R.id.second_radio_group);
        Integer secondAnswer = secondRadioGroup.getCheckedRadioButtonId();
        RadioGroup fourthRadioGroup = findViewById(R.id.fourth_radio_group);
        Integer fourthAnswer = fourthRadioGroup.getCheckedRadioButtonId();
        EditText thirdEditText1 = findViewById(R.id.third_question_answer_1);
        String thirdAnswer1 = thirdEditText1.getText().toString();
        EditText thirdEditText2 = findViewById(R.id.third_question_answer_2);
        String thirdAnswer2 = thirdEditText2.getText().toString();
        EditText fifthEditText = findViewById(R.id.fifth_question_answer);
        String fifthAnswer = fifthEditText.getText().toString();
        EditText sixthEditText1 = findViewById(R.id.sixth_question_answer_1);
        String sixthAnswer1 = sixthEditText1.getText().toString();
        EditText sixthEditText2 = findViewById(R.id.sixth_question_answer_2);
        String sixthAnswer2 = sixthEditText2.getText().toString();
        EditText sixthEditText3 = findViewById(R.id.sixth_question_answer_3);
        String sixthAnswer3 = sixthEditText3.getText().toString();
        CheckBox seventhOption1 = findViewById(R.id.seventh_option_1);
        Boolean seventhFirst = seventhOption1.isChecked();
        CheckBox seventhOption2 = findViewById(R.id.seventh_option_2);
        Boolean seventhSecond = seventhOption2.isChecked();
        CheckBox seventhOption3 = findViewById(R.id.seventh_option_3);
        Boolean seventhThird = seventhOption3.isChecked();
        CheckBox seventhOption4 = findViewById(R.id.seventh_option_4);
        Boolean seventhFourth = seventhOption4.isChecked();

        Boolean validateCheckBoxes = seventhFirst||seventhSecond||seventhThird||seventhFourth;


        if (firstAnswer == -1 || secondAnswer == -1 || fourthAnswer == -1 ||
                thirdAnswer1.isEmpty() || thirdAnswer2.isEmpty() || fifthAnswer.isEmpty() ||
                sixthAnswer1.isEmpty() || sixthAnswer2.isEmpty() || sixthAnswer3.isEmpty() ||
                !validateCheckBoxes){
            Toast.makeText(this, "Please answer all questions before submitting.", Toast.LENGTH_LONG).show();
        }else{
            RadioButton selectedFirstAnswer = findViewById(firstAnswer);
            RadioButton selectedSecondAnswer = findViewById(secondAnswer);
            RadioButton selectedFourthAnswer = findViewById(fourthAnswer);

            if (selectedFirstAnswer.getText().toString().equals("Germany")){
                score = score + 1;
            }

            if (selectedSecondAnswer.getText().toString().equals("True")){
                score = score + 1;
            }

            if (selectedFourthAnswer.getText().toString().equals("China")){
                score = score + 1;
            }

            if (thirdAnswer1.equalsIgnoreCase("CHRISTMAS") && thirdAnswer2.equalsIgnoreCase("MEXICO")){
                score = score + 1;
            }

            if (fifthAnswer.equalsIgnoreCase("RABANADA")){
                score = score + 1;
            }

            if (sixthAnswer1.equalsIgnoreCase("CHRISTMAS") && sixthAnswer2.equalsIgnoreCase("STOCKINGS") && sixthAnswer3.equalsIgnoreCase("EVE")){
                score = score + 1;
            }

            if (seventhThird && !seventhFirst && !seventhSecond && !seventhFourth){
                score = score + 1;
            }

            String a = "You scored";
            String b = "out of 6. Congratulations.";
            String scoreText = a + " "+ score.toString()+ " " + b;
            Toast.makeText(this, scoreText, Toast.LENGTH_LONG).show();

            String answerText = "The answers are:";
            answerText += "\nChristmas Trees : Germany";
            answerText += "\n";
            answerText += "\n"+getResources().getString(R.string.first_question_toast);
            answerText += "\n";
            answerText += "\nJingle Bells : True";
            answerText += "\n";
            answerText += "\n"+getResources().getString(R.string.second_question_toast);
            answerText += "\n";
            answerText += "\nFlowery : Christmas and Mexico";
            answerText += "\n";
            answerText += "\nDecorations : China";
            answerText += "\n";
            answerText += "\n"+getResources().getString(R.string.fourth_question_toast);
            answerText += "\n";
            answerText += "\nToasty : Rabanada";
            answerText += "\n";
            answerText += "\n"+getResources().getString(R.string.fifth_question_toast);
            answerText += "\n";
            answerText += "\nSanta : Christmas, Stockings and Eve";
            answerText += "\n";
            answerText += "\n"+getResources().getString(R.string.sixth_question_toast);

            TextView answerTextView = findViewById(R.id.answer_text_view);
            answerTextView.setText(answerText);
        }
    }

}
