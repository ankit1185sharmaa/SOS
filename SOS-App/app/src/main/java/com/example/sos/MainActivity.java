package com.example.sos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText number;
    private TextView text1;
    private SensorManager sm;
    private float acelVal; // we made it to get current acceleration value and gravity
    private float acelLast; // last acceleration gravity
    private float shake; //acceleration value that will change
    Context context=this;
    String s1="HELP";
    String s2="Help";
    String s3="help";



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //now lets ask the user for the permissions explicitly
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);



        //lets get the number
         number = findViewById(R.id.number);
        text1 = findViewById(R.id.text1);
        sm =(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorLister, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) ,SensorManager.SENSOR_DELAY_NORMAL);

        acelVal = SensorManager.GRAVITY_EARTH;
        acelLast = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;  // it means phn is in stable condition

    }
    private final SensorEventListener sensorLister = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {

            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            acelLast = acelVal;
            acelVal = (float) Math.sqrt((double) (x*x +y*y + z*z ));
            float delta = acelVal-acelLast;
            shake = shake * 0.9f + delta;

            if(shake >12) {

                getspeechInput();

            }
        }

        public void call(){
            Intent intent = new Intent(context, MainActivity2.class);
            startActivity(intent);

        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };




//speech to text convert
    public void getspeechInput() {
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
                    text1.setText(result.get(0));

                    String message = text1.getText().toString().trim();
                    String getnumber = number.getText().toString().trim();



                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(getnumber, null, message, null, null);
                        //in the above code we just code that what ever we will say it will just convert into a string


                } else  {
                    Toast.makeText(this, "message sent ", Toast.LENGTH_SHORT).show();
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    text1.setText(result.get(0));

                    String message = text1.getText().toString().trim();
                    String getnumber = number.getText().toString().trim();


                                          SmsManager smsManager = SmsManager.getDefault();
                        String primaryMessage = "need help";
                        smsManager.sendTextMessage(getnumber, null, primaryMessage, null, null);
                        smsManager.sendTextMessage(getnumber, null, message, null, null);



                    }

                }

        }


    public void getspeechInput(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH); // creat a speech recognizer...
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        //now i will get the default language of the system
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        getspeechInput();

    }
}



