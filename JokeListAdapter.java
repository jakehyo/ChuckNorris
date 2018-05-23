package com.example.han.chucknorris;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by per6 on 1/29/18.
 */

public class JokeListAdapter extends RecyclerView.Adapter<JokeListAdapter.MyViewHolder>{

    private Context context;
    private JokeList jokeList;

    public JokeListAdapter(Context context, JokeList jokeList) {
        this.context = context;
        this.jokeList = jokeList;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.joke_item, parent, false);
        return new MyViewHolder (itemView);
    }

    public void onBindViewHolder(MyViewHolder holder, int position){
        List<Joke> jokes = jokeList.getResult();
        Joke joke = jokes.get(position);
        Picasso.with(context).load(joke.getIcon_url()).resize(50, 50).into(holder.imageView);
        holder.jokeText.setText(joke.getValue());
    }

    public int getItemCount() {return jokeList.getTotal();}

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView jokeText;
        private ImageView imageView;

        public MyViewHolder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            jokeText = itemView.findViewById(R.id.jokeTextView);
        }

    }
 }
