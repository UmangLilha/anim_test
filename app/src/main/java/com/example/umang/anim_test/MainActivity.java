package com.example.umang.anim_test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity{

    ImageView imageView;
    Button button;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.imageView);

         intent=new Intent(MainActivity.this,MusicReceiver.class);
        intent.putExtra("extra","start");

        Thread xyz=new Thread()
        {
            public void run()
            {
                try {
                    sleep(2000);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                   /* Intent abc=new Intent(Launcher.this,MainActivity.class);
                    startActivity(abc);*/
                    Log.e("Main Class","Yayyyy!!");
                    sendBroadcast(intent);
                    Animation animation = new TranslateAnimation(0, 0,0, 1000);

                    animation.setDuration(2000);
                    animation.setFillAfter(true);
                    animation.setInterpolator(new BounceInterpolator());
                    animation.setAnimationListener(new Animation.AnimationListener() {

                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {

                            imageView.clearAnimation();
                            final int left = imageView.getLeft();
                            final int top = imageView.getTop();
                            final int right = imageView.getRight();
                            final int bottom = imageView.getBottom();
                            imageView.layout(left, top, right, bottom);

                        }
                    });
                    imageView.startAnimation(animation);
                    Thread umang=new Thread() {
                        public void run() {
                            try

                            {
                                sleep(3000);
                                Intent abc=new Intent(MainActivity.this,Display.class);
                                abc.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                abc.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                abc.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(abc);




                            } catch (
                                    Exception e)

                            {
                                e.printStackTrace();
                            } finally

                            {

                            }
                        }
                    };
                    umang.start();
                }
            }




        };
        xyz.start();


    }


}

