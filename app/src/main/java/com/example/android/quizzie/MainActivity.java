package com.example.android.quizzie;

import android.content.Intent;
import android.location.Address;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.checked;
import static android.R.id.message;

public class MainActivity extends AppCompatActivity {
    int totalPoints = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitQuiz(View view){
        totalPoints = onRadioButtonClicked(view);
        String Address[] = {"abc@gmail.com"};
        String subject = "Quizzie Quiz Results!";
        String message = "";
        Toast.makeText(this,"points--"+totalPoints, Toast.LENGTH_SHORT).show();
        if( totalPoints < 10){
            int lostPoints = 10 - totalPoints;
            message = "Quizzie Quiz results are out!!\n\n";
            message = message + "You have "+lostPoints+" wrong answers.\n";
            message = message + "\nYour Total Score : " + totalPoints;
        }
        if( totalPoints == 10 ) {
            message = "Quizzie Quiz results are out!!\n\n";
            message = message + "YOU ARE AWESOME\n!!!";
            message = message + "\nCongratulations!!!!\nYou got all answers right.";
            message = message + "\n\nYou have scored " + totalPoints+"\n";
        }
        composeEmail(Address, subject, message);

        //Toast.makeText(this,"points--"+totalPoints, Toast.LENGTH_SHORT).show();
    }
    public int onRadioButtonClicked(View view){
        RadioButton buttonView1 = (RadioButton)findViewById(R.id.radiobutton1_Q1);
        RadioButton buttonView2 = (RadioButton)findViewById(R.id.radiobutton1_Q2);
        RadioButton buttonView3 = (RadioButton)findViewById(R.id.radiobutton1_Q3);
        RadioButton buttonView4 = (RadioButton)findViewById(R.id.radiobutton1_Q4);
        RadioButton buttonView5 = (RadioButton)findViewById(R.id.radiobutton1_Q5);
        RadioButton buttonView6 = (RadioButton)findViewById(R.id.radiobutton1_Q6);
        RadioButton buttonView7 = (RadioButton)findViewById(R.id.radiobutton1_Q7);
        RadioButton buttonView8 = (RadioButton)findViewById(R.id.radiobutton1_Q8);
        RadioButton buttonView9 = (RadioButton)findViewById(R.id.radiobutton1_Q9);
        RadioButton buttonView10 = (RadioButton)findViewById(R.id.radiobutton1_Q10);

        int points = 0;
        if(buttonView1.isChecked()){
            points++;
        }
        if(buttonView2.isChecked()){
            points++;
        }
        if(buttonView3.isChecked()){
            points++;
        }
        if(buttonView4.isChecked()){
            points++;
        }
        if(buttonView5.isChecked()){
            points++;
        }
        if(buttonView6.isChecked()){
            points++;
        }
        if(buttonView7.isChecked()){
            points++;
        }
        if(buttonView8.isChecked()){
            points++;
        }
        if(buttonView9.isChecked()){
            points++;
        }
        if(buttonView10.isChecked()){
            points++;
        }

        return points;
    }
    public void composeEmail(String[] addresses, String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
