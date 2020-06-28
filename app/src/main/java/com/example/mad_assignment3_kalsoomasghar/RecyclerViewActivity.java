package com.example.mad_assignment3_kalsoomasghar;


import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private static final String TAG = "RecyclerViewActivity";

    List<ModelClass> modelClassList= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        Log.d(TAG, "onCreate: started. ");

        setData();
        initRecyclerView();

    }


    private void initRecyclerView()
    {
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recyclerv);
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(getApplicationContext(), modelClassList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setData()
    {
        modelClassList.add(new ModelClass("https://facebookbrand.com/wp-content/uploads/2019/04/f_logo_RGB-Hex-Blue_512.png?w=512&h=512"
                ,"Facebook","kalsoomasghar11@gmail.com","0300-0000000"));
        modelClassList.add(new ModelClass("https://img.icons8.com/color/480/whatsapp.png"
                ,"Whatsapp","kalsoomasghar11@gmail.com","0300-0000000"));
        modelClassList.add(new ModelClass("https://howla.com/wp-content/uploads/2017/03/Uber_Logo_Black-1465x1080.png"
                ,"Uber","kalsoomasghar11@gmail.com","0300-0000000"));
        modelClassList.add(new ModelClass("https://www.omnicoreagency.com/wp-content/uploads/2015/10/Twitter-Logo.png"
                ,"Twitter","kalsoomasghar11@gmail.com","0300-0000000"));
        modelClassList.add(new ModelClass("https://neilpatel.com/wp-content/uploads/2016/01/pinterest.png"
                ,"Pinterest","kalsoomasghar11@gmail.com","0300-0000000"));
        modelClassList.add(new ModelClass("https://thenextweb.com/wp-content/blogs.dir/1/files/2016/05/instagram-logo.png"
                ,"Instagram","kalsoomasghar11@gmail.com","0300-0000000"));
    }


}
