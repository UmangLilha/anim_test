package com.example.umang.anim_test;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Display extends AppCompatActivity {
 Intent intent;
 public static  EditText editText;
 public static  TextView name,gender;
    private Boolean exit = false;
 Button submit;
 String url="https://api.genderize.io/?name=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        intent=new Intent(Display.this,MusicReceiver.class);
        intent.putExtra("extra","stop");
        editText=(EditText)findViewById(R.id.editText);
        submit=(Button)findViewById(R.id.button);
        name=(TextView)findViewById(R.id.name);
        gender=(TextView)findViewById(R.id.gender);
                //url=url+editText.getText().toString();
               submit.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       Log.e("Display class","Yayyyy!!");
                       Data process=new Data();
                       process.execute();
                   }
               });



    }

    @Override
    protected void onPause() {
        super.onPause();

       // sendBroadcast(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
       // sendBroadcast(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
    @Override
    public void onBackPressed() {
        if (exit) {
            sendBroadcast(intent);
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }
}
