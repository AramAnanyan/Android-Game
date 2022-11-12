package com.example.myapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView image1;
    ImageView image2;
    ImageView image3;
    TextView start_button;
    private boolean done=true;
    private boolean started=false;
    private int mn=0;

    public int[] images={R.mipmap.kivi,R.mipmap.ananas,R.mipmap.xndzor};
    public int[] imagesConst={R.mipmap.kivi,R.mipmap.ananas,R.mipmap.xndzor};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int n=2;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1=findViewById(R.id.first);
        image2=findViewById(R.id.second);
        image3=findViewById(R.id.third);
        start_button=findViewById(R.id.start_button);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(done) {
                    mn=0;
                    for (int i = 0; i < images.length; i++) {
                        imagesConst[i] = images[i];
                    }
                    Random random = new Random();
                    for (int i = 0; i < images.length - 1; i++) {
                        int k = random.nextInt(images.length - i) + i;
                        int val = images[k];
                        images[k] = images[i];
                        images[i] = val;

                    }

                    image1.setImageResource(images[0]);
                    image2.setImageResource(images[1]);
                    image3.setImageResource(images[2]);
                    start_button.setVisibility(view.INVISIBLE);

                    started=true;
                    done=false;
                }
            }
        });
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(started && image1.getVisibility()==view.VISIBLE){

                    if(imagesConst[mn]==images[0]){
                        image1.setVisibility(view.INVISIBLE);
                        mn++;
                    }
                    if(mn==3){
                        started=false;
                        done=true;
                        start_button.setVisibility(view.VISIBLE);
                        for (int i = 0; i < images.length; i++) {
                            imagesConst[i] = images[i];
                        }
                        Random random = new Random();
                        for (int i = 0; i < images.length - 1; i++) {
                            int k = random.nextInt(images.length - i) + i;
                            int val = images[k];
                            images[k] = images[i];
                            images[i] = val;

                        }
                        image1.setVisibility(view.VISIBLE);
                        image2.setVisibility(view.VISIBLE);
                        image3.setVisibility(view.VISIBLE);
                    }

                    }


            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(started && image2.getVisibility()==view.VISIBLE){
                    if(imagesConst[mn]==images[1]){
                        image2.setVisibility(view.INVISIBLE);
                        mn++;
                    }
                    if(mn==3){
                        started=false;
                        done=true;
                        start_button.setVisibility(view.VISIBLE);

                        for (int i = 0; i < images.length; i++) {
                            imagesConst[i] = images[i];
                        }
                        Random random = new Random();
                        for (int i = 0; i < images.length - 1; i++) {
                            int k = random.nextInt(images.length - i) + i;
                            int val = images[k];
                            images[k] = images[i];
                            images[i] = val;

                        }
                        image2.setVisibility(view.VISIBLE);
                        image3.setVisibility(view.VISIBLE);
                        image1.setVisibility(view.VISIBLE);

                    }

                }

            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(started){
                    if(imagesConst[mn]==images[2] && image3.getVisibility()==view.VISIBLE){
                        image3.setVisibility(view.INVISIBLE);
                        mn++;
                    }
                    if(mn==3){
                        started=false;
                        done=true;
                        start_button.setVisibility(view.VISIBLE);

                    }
                    for (int i = 0; i < images.length; i++) {
                        imagesConst[i] = images[i];
                    }
                    Random random = new Random();
                    for (int i = 0; i < images.length - 1; i++) {
                        int k = random.nextInt(images.length - i) + i;
                        int val = images[k];
                        images[k] = images[i];
                        images[i] = val;

                    }
                    image3.setVisibility(view.VISIBLE);
                    image1.setVisibility(view.VISIBLE);
                    image2.setVisibility(view.VISIBLE);
                }

            }
        });



    }
}