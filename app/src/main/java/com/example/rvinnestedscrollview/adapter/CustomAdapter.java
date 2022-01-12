package com.example.rvinnestedscrollview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rvinnestedscrollview.R;
import com.example.rvinnestedscrollview.model.User;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<User> users;

    public CustomAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }


    @Override
    public int getItemCount() {
        return users.size();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_custom_layout_view, parent, false);
        return new CustomViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user =users.get(position);

        if (holder instanceof CustomViewHolder){
            TextView firstN = ((CustomViewHolder)holder).firstName;
            TextView lastN = ((CustomViewHolder)holder).lastName;

            firstN.setText(user.getFirstName());
            lastN.setText(user.getLastName());
        }
    }


    class CustomViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView firstName;
        public TextView lastName;

        public CustomViewHolder(View v){
            super(v);
            this.view = v;
            firstName = view.findViewById(R.id.firstName);
            lastName = view.findViewById(R.id.lastName);
        }
    }

}
