package com.example.multilang2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textview;
    private Locale locale;
    private Configuration config = new Configuration();





    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = ((Button)findViewById(R.id.button));
        textview = ((TextView)findViewById(R.id.textview));

        /*SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("lang", "pt");
        editor.commit();*/



        Context context = getApplicationContext();
        CharSequence text;
        int duration = Toast.LENGTH_SHORT;

        /*SharedPreferences sharedPref2 = this.getPreferences(Context.MODE_PRIVATE);
        //int defaultValue = getResources().getInteger(R.string.saved_high_score_default);
        text = sharedPref2.getString("lang", null);*/

        Toast toast = Toast.makeText(context, Locale.getDefault().getLanguage(), duration);
        toast.show();



        button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        showDialog();
                    }});
    }

    /**
     * Muestra una ventana de dialogo para elegir el nuevo idioma de la aplicacion
     * Cuando se hace clic en uno de los idiomas, se cambia el idioma de la aplicacion
     * y se recarga la actividad para ver los cambios
     * */
    private void showDialog(){


        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle(getResources().getString(R.string.str_button));
        //obtiene los idiomas del array de string.xml
        String[] types = getResources().getStringArray(R.array.languages);
        b.setItems(types, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                Context context = getApplicationContext();
                //String filename = "lang";
                String pre_lang;
                FileOutputStream out;

                dialog.dismiss();
                switch(which){
                    case 0:
                        pre_lang ="en";
                        context = MyContextWrapper.wrap(context, pre_lang);
                        recreate();

                        break;
                    case 1:
                        pre_lang ="es";
                        context = MyContextWrapper.wrap(context, pre_lang);
                        recreate();

                        break;
                    case 2:
                        pre_lang ="fr";
                        context = MyContextWrapper.wrap(context, pre_lang);
                        recreate();

                        break;
                    case 3:
                        pre_lang ="pt";
                        context = MyContextWrapper.wrap(context, pre_lang);
                        recreate();

                        break;
                }


                //Intent refresh = new Intent(MainActivity.this, MainActivity.class);
                //startActivity(refresh);
                //finish();
            }

        });

        b.show();
    }

    public void Dale(View v){

        Intent intent = new Intent(this, Idiomas.class);
        startActivity(intent);
        finish();

    }


    @Override
    protected void attachBaseContext(Context newBase) {

           // String filename = "lang";

        /*else if(Locale.getDefault().getDisplayLanguage() == "español") pre_lang = "es";
        else if(Locale.getDefault().getDisplayLanguage() == "Françáis") pre_lang = "fr";
        else if(Locale.getDefault().getDisplayLanguage() == "Português") pre_lang = "pt";*/


        /*try {
            BufferedReader fin = new BufferedReader(new InputStreamReader(openFileInput(filename)));
            pre_lang = fin.readLine();
            fin.close();

        } catch (Exception e) {
            e.printStackTrace();
        }*/


        //SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        //int defaultValue = getResources().getInteger(R.string.saved_high_score_default);
        //pre_lang = sharedPref.getString("lang", null);





       super.attachBaseContext(MyContextWrapper.wrap(newBase,Locale.getDefault().getLanguage()));
    }



}

