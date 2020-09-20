package com.example.practical15;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_mobile;
    Button btn_call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_mobile = findViewById(R.id.et_mobile);
        btn_call = findViewById(R.id.btn_call);

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mob = et_mobile.getText().toString();
                if (mob.isEmpty()){
                    et_mobile.setError("Please Enter mobile number");
                    et_mobile.requestFocus();
                }else if (mob.length() != 10){
                    et_mobile.setError("Mobile number Should be 10 digits");
                    et_mobile.requestFocus();
                }else {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    Log.e("TAG","tel:"+mob);
                    callIntent.setData(Uri.parse("tel:"+mob));

                    if (ActivityCompat.checkSelfPermission(MainActivity.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(callIntent);
                }
            }
        });
    }
}