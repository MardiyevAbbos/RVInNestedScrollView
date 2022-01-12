package com.example.rvinnestedscrollview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.rvinnestedscrollview.R;
import com.example.rvinnestedscrollview.adapter.CustomAdapter;
import com.example.rvinnestedscrollview.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;
    private NestedScrollView nestedScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        ArrayList<User> users = prepareUserList();
        refreshAdapter(users);

    }

    private void initViews() {
        context = this;
        nestedScrollView = findViewById(R.id.nestedScrollView);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }


    private void refreshAdapter(ArrayList<User> users) {
        CustomAdapter adapter = new CustomAdapter(context, users);
        recyclerView.setAdapter(adapter);
        nestedScrollView.setNestedScrollingEnabled(false);
    }


    private ArrayList<User> prepareUserList() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            users.add(new User(i + ")Michael", i + ")Jackson"));
        }
        return users;
    }


}