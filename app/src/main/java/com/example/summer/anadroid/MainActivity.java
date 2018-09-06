package com.example.summer.anadroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.summer.anadroid.activity.CardViewActiviy;
import com.example.summer.anadroid.activity.MRecyclerViewActivty;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.but_recyclerview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jump(MRecyclerViewActivty.class);
            }
        });

        findViewById(R.id.but_ardviewactiviy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jump(CardViewActiviy.class);
            }
        });

    }
    private void jump(Class<?> activity){
        Intent intent = new Intent();
        intent.setClass(this,activity);
        startActivity(intent);
    }

}
