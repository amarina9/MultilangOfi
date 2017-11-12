package com.example.multilang2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Locale;


public class Idiomas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idiomas);
    }


    public void Volver(View v){

        /*String filename = "lang";
        String string = "es";
        String pre_lang = "kk";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



        try {
            BufferedReader fin = new BufferedReader(new InputStreamReader(openFileInput(filename)));
            pre_lang = fin.readLine();
            fin.close();

        } catch (Exception e) {
            e.printStackTrace();
        }*/


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    protected void attachBaseContext(Context newBase) {

            super.attachBaseContext(MyContextWrapper.wrap(newBase,Locale.getDefault().getLanguage()));
    }


}
