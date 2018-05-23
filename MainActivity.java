package com.example.han.chucknorris;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private JokeList jokeList;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private JokeListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jokeList = new JokeList();

        //wire the recycler view
        recyclerView = findViewById(R.id.recyclerView);
        //create a layout manager for the recycler view
        layoutManager = new LinearLayoutManager(this);
        //set the layout manager to the recyclerview
        recyclerView.setLayoutManager(layoutManager);
        //set the default animator to the recyclerview
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //create the adapter
        adapter = new JokeListAdapter(this, jokeList);
        //set the adapter
        recyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ChuckNorrisAPI.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //instantiate an API
        ChuckNorrisAPI api = retrofit.create(ChuckNorrisAPI.class);

        Call<JokeList> call = api.getJokeList("art");


        call.enqueue(new Callback<JokeList>() {
            @Override
            public void onResponse(Call<JokeList> call, Response<JokeList> response) {
                //List<Joke> jokes = response.body().getResult();
                //Log.d("IT WORKED", "onResponse: " + jokes);
                jokeList.listClear();
                jokeList.totalClear();
                List<Joke> temp = new ArrayList<>();
                temp.addAll(response.body().getResult());
                jokeList.setResult(temp);
                jokeList.setTotal(response.body().getTotal());
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<JokeList> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
