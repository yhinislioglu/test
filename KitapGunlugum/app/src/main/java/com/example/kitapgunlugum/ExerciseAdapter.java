package com.example.kitapgunlugum;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kitapgunlugum.api.ExerciseResponse;

import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder> {
    Context context;
    List<ExerciseResponse> exerciseList;

    public ExerciseAdapter(Context context,List<ExerciseResponse> exerciseList)
    {
        this.context = context;
        this.exerciseList = exerciseList;
    }

    public void setExerciseList(List<ExerciseResponse> exerciseList)
    {
        this.exerciseList = exerciseList;
        notifyDataSetChanged();
    }

    @Override
    public ExerciseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_exercise_item,parent,false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExerciseViewHolder holder, int position) {
        holder.mlblExerciseID.setText(exerciseList.get(position).getId().toString());
        holder.mlblExerciseName.setText(exerciseList.get(position).getExercise_name());
        holder.mlblExamName.setText(exerciseList.get(position).getExam());
        holder.mlblStatus.setText(exerciseList.get(position).getStatus());



        if (exerciseList.get(position).getStatus()=="c"){
            holder.mExerciseCardView.setCardBackgroundColor(ContextCompat.getColor(context,R.color.CreateColor));
        }else if (exerciseList.get(position).getStatus()=="r"){
            holder.mExerciseCardView.setCardBackgroundColor(Color.RED);
        }else if (exerciseList.get(position).getStatus()=="e"){
            holder.mExerciseCardView.setCardBackgroundColor(Color.YELLOW);
        }else if (exerciseList.get(position).getStatus()=="s"){
            holder.mExerciseCardView.setCardBackgroundColor(Color.GREEN);
        }

    }

    @Override
    public int getItemCount() {
        if (exerciseList != null){
            return exerciseList.size();
        }
        return 0;
    }

    public class ExerciseViewHolder extends RecyclerView.ViewHolder
    {
        TextView mlblExerciseID,mlblExerciseName,mlblExamName,mlblStatus;
        CardView mExerciseCardView;
        public ExerciseViewHolder(View view)
        {
            super(view);
            mlblExerciseID = view.findViewById(R.id.lblExerciseID);
            mlblExerciseName = view.findViewById(R.id.lblExerciseName);
            mlblExamName = view.findViewById(R.id.lblExamName);
            mlblStatus = view.findViewById(R.id.lblStatus);
            mExerciseCardView = view.findViewById(R.id.exerciseCardView);
        }
    }
}
