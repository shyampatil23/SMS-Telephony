package com.example.smstelephony;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_mobile_no,et_message;
    Button btn_send;
    String number,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_mobile_no = findViewById(R.id.et_number);
        et_message = findViewById(R.id.et_message);
        btn_send = findViewById(R.id.btn_send);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = et_mobile_no.getText().toString();
                message = et_message.getText().toString();

                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(),0,intent,0);

                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(number,null,message,pi,null);
                Toast.makeText(MainActivity.this,"Message Successfully Sent....",Toast.LENGTH_SHORT).show();


            }
        });
    }
}
