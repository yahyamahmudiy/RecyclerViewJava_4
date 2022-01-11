package com.example.task4.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.task4.Adapter.RecyclerAdapter;
import com.example.task4.Listener.OnButtomReachedListener;
import com.example.task4.Model.Member;
import com.example.task4.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews(){
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));

        ArrayList<Member> members = new ArrayList<>();

        members.add(new Member());
        for (int i=0;i<=20;i++){
            if(i == 0 ||i == 5 || i == 10 || i == 15 || i == 20) {
                members.add(new Member(R.mipmap.ic_profile, "Yahya " + i, "Mahmudiy " + i, false));
            }else {
                members.add(new Member(R.mipmap.ic_profile, "Yahya " + i, "Mahmudiy " + i, true));
            }
        }
        members.add(new Member());

        refreshAdapter(members);
    }

    void refreshAdapter(ArrayList<Member> members){
        RecyclerAdapter adapter = new RecyclerAdapter(context,members,new OnButtomReachedListener(){
            @Override
            public void onBottomReached(int position) {
                //Log.d("@@@","@@@position " + position);
                Toast.makeText(MainActivity.this,"You have reached the end",Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
    }
}