package com.example.userpermissiom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    String[] permi = {Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestPermissions(permi,203);

        findViewById(R.id.chackbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isNetworkConnected()){

                    Toast.makeText(MainActivity.this,"connected",Toast.LENGTH_SHORT);
                }
                else {


                    Toast.makeText(MainActivity.this,"not connected",Toast.LENGTH_SHORT);
                }


            }
        });
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==203){

            if (grantResults[0]== PackageManager.PERMISSION_GRANTED){

                Toast.makeText(this,"permission granted",Toast.LENGTH_SHORT).show();
            }else {

                Toast.makeText(this,"permission denid",Toast.LENGTH_SHORT).show();
                finish();
            }
        }
        if (grantResults[1]== PackageManager.PERMISSION_DENIED){

            Toast.makeText(this,"permission granted",Toast.LENGTH_SHORT).show();
        }else {

            Toast.makeText(this,"permission denid",Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}