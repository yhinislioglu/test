package com.example.kitapgunlugum;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kitapgunlugum.api.MyBookInfo;
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
    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private RecyclerViewMyBookAdapter recyclerViewMyBookAdapter;

    private ArrayList<MyBookResponse> myBookResponseArrayList;
    //private TextView textView;
    Token token = new Token();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_book);
        recyclerView = findViewById(R.id.recyclerViewMyBook);
        //textView = findViewById(R.id.textView2);
        //fetchJSON();

        requestMethod();
    }
/*
    private void fetchJSON()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitLoginService.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create()).build();
        RetrofitLoginService api = retrofit.create(RetrofitLoginService.class);
        Call<String> call = api.myBookResponseCall("Token " + token.getAuthorizationToken());
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("ResponseString",response.body().toString());
                if (response.isSuccessful())
                {
                    if (response.body() != null)
                    {
                        Log.i("onSuccess",response.body().toString());
                        String jsonResponse = response.body().toString();
                        writeRecycler(jsonResponse);
                    } else {
                        Log.i("onEmptyResponse" , "Return empty response");
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }

    private void writeRecycler(String response)
    {
        try {

            JSONArray jsonArray = new JSONArray(response);
            ArrayList<MyBookResponse> myBookResponseArrayList = new ArrayList<>();

            //textView.setText(jsonArray.toString());

            for (int i=0; i < jsonArray.length(); i++)
            {
                MyBookResponse myBookResponse = new MyBookResponse();

                JSONObject object = jsonArray.getJSONObject(i);
                myBookResponse.setPk(object.getString("pk"));
                myBookResponse.setBook_name(object.getString("book_name"));
                myBookResponse.setPage_number(object.getString("page_number"));
                myBookResponse.setSub_title(object.getString("sub_title"));
                myBookResponse.setBarcode(object.getString("barcode"));



                myBookResponseArrayList.add(myBookResponse);
            }

            recyclerViewMyBookAdapter = new RecyclerViewMyBookAdapter(this,myBookResponseArrayList);
            recyclerView.setAdapter(recyclerViewMyBookAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayout.VERTICAL,false));



        }catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

*/


    private void requestMethod()
    {
        progressDialog = new ProgressDialog(MyBookActivity.this);
        progressDialog.setMessage("Kitaplar yükleniyor...");
        progressDialog.show();
        recyclerView = findViewById(R.id.recyclerViewMyBook);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitLoginService.BASE_URL)
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
                    myBookResponseArrayList = new ArrayList<MyBookResponse>();
                    myBookResponseArrayList.add(myBookResponse);
                    //txtview = findViewById(R.id.textView2);
                    //txtview.setText(myBookResponseArrayList.get(0).getBook_name());
                    //progressDialog.dismiss();
                    RecyclerViewMyBookAdapter bookAdapter = new RecyclerViewMyBookAdapter(MyBookActivity.this,myBookResponseArrayList);
                    recyclerView.setAdapter(bookAdapter);
                    //AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(MyBookActivity.this,500);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayout.VERTICAL,false));
                }

            }

            @Override
            public void onFailure(Call<MyBookResponse> call, Throwable t) {

            }
        });

    }


}
