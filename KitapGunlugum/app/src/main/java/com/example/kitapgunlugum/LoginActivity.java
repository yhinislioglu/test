package com.example.kitapgunlugum;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kitapgunlugum.api.LoginInfo;
import com.example.kitapgunlugum.api.LoginResponse;
import com.example.kitapgunlugum.api.RetrofitLoginService;
import com.example.kitapgunlugum.api.Token;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    public Token token = new Token();

    private Button loginBtn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private ProgressDialog progressDialog;
    private List<LoginResponse> loginResponseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        loginBtn = findViewById(R.id.btnLogin);
        editTextEmail = findViewById(R.id.txtEmail);
        editTextPassword = findViewById(R.id.txtParola);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmpty(editTextEmail) && !isEmpty(editTextPassword)){
                    postRequestMethod();
                }else if(isEmpty(editTextEmail)) {
                    editTextEmail.requestFocus();
                    editTextEmail.setError("Email adresini giriniz.");
                } else if(isEmpty(editTextPassword)){
                    editTextPassword.requestFocus();
                    editTextPassword.setError("Şifrenizi giriniz.");
                }
            }
        });



    }

    private boolean isEmpty(EditText edittext) {
        if (edittext.getText().toString().trim().length() > 0)
            return false;

        return true;
    }

    private void postRequestMethod(){
        progressDialog = new ProgressDialog(LoginActivity.this);

        progressDialog.setMessage("Lütfen Bekleyin...");
        progressDialog.show();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitLoginService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitLoginService retrofitLoginService = retrofit.create(RetrofitLoginService.class);
        LoginInfo loginInfo = new LoginInfo(editTextEmail.getText().toString(),editTextPassword.getText().toString());
        Call<LoginResponse> call = retrofitLoginService.loginResponseCall(loginInfo);
        Log.w("request",call.request().toString());
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                progressDialog.dismiss();
                LoginResponse loginResponse = response.body();
                if (response.body()!=null) {
                    loginResponseList = new ArrayList<LoginResponse>();
                    loginResponseList.add(loginResponse);

                    token.setAuthorizationToken(loginResponseList.get(0).getkey());

                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    //intent.putExtra("LoginKey",(Serializable) loginResponseList);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Kullanıcı Bilgileri Hatalı",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                progressDialog.dismiss();
            }
        });

    }

}