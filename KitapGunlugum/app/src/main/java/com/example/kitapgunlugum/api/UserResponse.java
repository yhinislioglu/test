package com.example.kitapgunlugum.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;



public class UserResponse implements Serializable {
    @SerializedName("pk")
    private String pk;
    @SerializedName("username")
    private String username;
    @SerializedName("email")
    private String email;
    @SerializedName("first_name")
    private String first_name;
    @SerializedName("last_name")
    private String last_name;

    public String getPk() {
        return pk;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }
}
