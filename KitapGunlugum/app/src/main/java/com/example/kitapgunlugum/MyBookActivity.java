package com.example.kitapgunlugum;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kitapgunlugum.api.ApiClient;
import com.example.kitapgunlugum.api.MyBookResponse;
import com.example.kitapgunlugum.api.RetrofitLoginService;
import com.example.kitapgunlugum.api.Token;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MyBookActivity extends AppCompatActivity {

    Token token = new Token();
    List<MyBookResponse> myBookList;
    RecyclerView recyclerView;
    MyBookAdapter myBookAdapter;
    private Toolbar toolbar;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_book);
/*
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
*/




        myBookList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerViewMyBook);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        myBookAdapter = new MyBookAdapter(getApplicationContext(),myBookList);
        recyclerView.setAdapter(myBookAdapter);


        RetrofitLoginService service = ApiClient.getClient().create(RetrofitLoginService.class);
        Call<List<MyBookResponse>> call = service.myBookResponseCall("Token " + token.getAuthorizationToken());

        call.enqueue(new Callback<List<MyBookResponse>>() {
            @Override
            public void onResponse(Call<List<MyBookResponse>> call, Response<List<MyBookResponse>> response) {
                myBookList = response.body();
                myBookAdapter.setBookList(myBookList);
            }

            @Override
            public void onFailure(Call<List<MyBookResponse>> call, Throwable t) {

            }
        });




    }
}
