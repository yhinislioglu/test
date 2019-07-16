package com.example.kitapgunlugum;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.kitapgunlugum.api.ApiClient;
import com.example.kitapgunlugum.api.ExerciseResponse;
import com.example.kitapgunlugum.api.RetrofitLoginService;
import com.example.kitapgunlugum.api.Token;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExerciseActivity extends AppCompatActivity {

    Token token = new Token();
    List<ExerciseResponse> exerciseResponseList;
    RecyclerView mRecyclerView;
    ExerciseAdapter exerciseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        exerciseResponseList = new ArrayList<>();
        mRecyclerView = findViewById(R.id.recyclerExercise);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        exerciseAdapter = new ExerciseAdapter(ExerciseActivity.this,exerciseResponseList);
        mRecyclerView.setAdapter(exerciseAdapter);

        getCall();




    }

    private void getCall()
    {
        RetrofitLoginService retrofit = ApiClient.getClient().create(RetrofitLoginService.class);
        Call<List<ExerciseResponse>> call = retrofit.exerciseGetCall("Token " + token.getAuthorizationToken());

        call.enqueue(new Callback<List<ExerciseResponse>>() {
            @Override
            public void onResponse(Call<List<ExerciseResponse>> call, Response<List<ExerciseResponse>> response) {
                exerciseResponseList = response.body();
                exerciseAdapter.setExerciseList(exerciseResponseList);
            }

            @Override
            public void onFailure(Call<List<ExerciseResponse>> call, Throwable t) {
                Toast.makeText(ExerciseActivity.this,"Servis hatalı geldi. Daha sonra tekrar deneyin !",Toast.LENGTH_LONG).show();
            }
        });
    }

}
