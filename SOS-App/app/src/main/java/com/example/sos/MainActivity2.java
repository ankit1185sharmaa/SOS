package com.example.sos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.telephony.SmsManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    private TextView textacti2;
    String s1="HELP";
    String s2="Help";
    String s3="help";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        check();


        }
        //speech to text check
     public void check(){

         Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
         intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
         //now i will get the default language of the system
         intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

         if (intent.resolveActivity(getPackageManager()) != null) {

             //i have used this if else statement to check that device is compatible with this kind of functions or not
             startActivityForResult(intent, 10);


         } else {
             Toast.makeText(this, "device not supported with voice capabilities", Toast.LENGTH_SHORT).show();
         }

     }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (requestCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textacti2.setText(result.get(0));

                    String message = textacti2.getText().toString().trim();



                    //in the above code we just code that what ever we will say it will just convert into a string


                } else {
                    Toast.makeText(this, "message sent ", Toast.LENGTH_SHORT).show();
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textacti2.setText(result.get(0));

                    String message = textacti2.getText().toString().trim();


                }

        }


    }



}

