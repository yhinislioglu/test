package com.example.kitapgunlugum;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.kitapgunlugum.api.MyBookInfo;
import com.example.kitapgunlugum.api.MyBookResponse;
import com.example.kitapgunlugum.api.RetrofitLoginService;
import com.example.kitapgunlugum.api.Token;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyBookActivity extends AppCompatActivity implements RecyclerViewMyBookAdapter.ItemListener {
    private ProgressDialog progressDialog;
    public static final String BASE_URL = "http://62.248.59.168:8623/api/edu/";
    private ArrayList<MyBookResponse> myBookResponseArrayList;
    public RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_book);

        requestMethod();


    }


    private void requestMethod()
    {
        progressDialog = new ProgressDialog(MyBookActivity.this);
        progressDialog.setMessage("Kitaplar yükleniyor...");
        progressDialog.show();
        recyclerView = findViewById(R.id.recyclerViewMyBook);
        Token token = new Token();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitLoginService service = retrofit.create(RetrofitLoginService.class);
        Call<MyBookResponse> call = service.myBookResponseCall("Token " + token.getAuthorizationToken());
        Log.w("request",call.request().toString());
        call.enqueue(new Callback<MyBookResponse>() {
            @Override
            public void onResponse(Call<MyBookResponse> call, Response<MyBookResponse> response) {
                progressDialog.dismiss();
                MyBookResponse myBookResponse = response.body();
                if (response.body() != null)
                {
                    myBookResponseArrayList = new ArrayList<>();
                    myBookResponseArrayList.add(myBookResponse);

                    RecyclerViewMyBookAdapter bookAdapter = new RecyclerViewMyBookAdapter(MyBookActivity.this,myBookResponseArrayList,MyBookActivity.this);
                    recyclerView.setAdapter(bookAdapter);
                    AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(MyBookActivity.this,500);
                    recyclerView.setLayoutManager(layoutManager);
                }

            }

            @Override
            public void onFailure(Call<MyBookResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void onItemClick(MyBookResponse item) {

    }
}
