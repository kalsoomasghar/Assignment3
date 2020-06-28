package com.example.mad_assignment3_kalsoomasghar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Screen2 extends AppCompatActivity {
        TextView s2name;
        TextView s2mailt;
        TextView s2callt;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_screen2);

            registerViews();
            getIncomingIntent();
        }
        private void registerViews()
        {
            Intent intent = getIntent();
            /******************/
            s2name= findViewById(R.id.s2name);
            String str1 =intent.getStringExtra("getTitle");
            s2name.setText(str1);
            /******************/
            s2mailt= findViewById(R.id.s2mailt);
            String str2 =intent.getStringExtra("getEmail");
            s2mailt.setText(str2);
            /******************/
            s2callt= findViewById(R.id.s2callt);
            String str3 =intent.getStringExtra("getPhone");
            s2callt.setText(str3);
            /******************/
        }

        private void getIncomingIntent()
        {
            String images=getIntent().getStringExtra("images");
            String names=getIntent().getStringExtra("names");
            String numbers=getIntent().getStringExtra("numbers");
            String emails=getIntent().getStringExtra("emamils");

            setImage(images,names,numbers,emails);

        }

        private void setImage( String image,String name,String numbers, String emails)
        {
            ImageView i=findViewById(R.id.s2image);
            Glide.with(this).asBitmap().load(image).into(i);

            TextView n=findViewById(R.id.s2name);
            n.setText(name);

            TextView num=findViewById(R.id.s2callt);
            num.setText(numbers);

            TextView jt=findViewById(R.id.s2mailt);
            jt.setText(emails);


        }
    }