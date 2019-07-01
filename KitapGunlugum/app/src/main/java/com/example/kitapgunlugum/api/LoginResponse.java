package com.example.kitapgunlugum.api;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginResponse implements Serializable {
    @SerializedName("key")
    private String key;

    public String getkey(){
        return key;
    }
}
