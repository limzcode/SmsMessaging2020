package com.example.smsmessaging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final private  int Request_SEND_SMS=123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
            != PackageManager.PERMISSION_GRANTED )



        {
            ActivityCompat.requestPermissions(this,new String [] { Manifest.permission.SEND_SMS}, Request_SEND_SMS);
        }




    }
    private void onRequestPersmissionResult(int requestcode, String[] permission, int[] grantResults){
        switch (requestcode){
            case Request_SEND_SMS:
                if (grantResults[0] == PackageManager . PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this ,"permission Denied", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Permission Denied",Toast.LENGTH_SHORT).show();
                }
                break;
                default:
                    super. onRequestPermissionsResult(requestcode,permission,grantResults);
        }
    }

    public void onClick(View view) {
        sendSMS("5554","Hello my friends!");
    }
    private void sendSMS(String phoneNumber,String message){
   SmsManager sms = SmsManager.getDefault();
   sms.sendTextMessage(phoneNumber,null ,message,null,null);
    }
}
