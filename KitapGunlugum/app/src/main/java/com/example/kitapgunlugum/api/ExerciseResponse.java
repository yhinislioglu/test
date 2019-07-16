package com.example.kitapgunlugum.api;

import com.google.gson.annotations.SerializedName;

public class ExerciseResponse {
    @SerializedName("id")
    private Integer id;
    @SerializedName("exercise_name")
    private String exercise_name;
    @SerializedName("exam")
    private String exam;
    @SerializedName("status")
    private String status;

    public ExerciseResponse(Integer id,String exercise_name,String exam,String status)
    {
        this.id = id;
        this.exercise_name = exercise_name;
        this.exam = exam;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExercise_name() {
        return exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
