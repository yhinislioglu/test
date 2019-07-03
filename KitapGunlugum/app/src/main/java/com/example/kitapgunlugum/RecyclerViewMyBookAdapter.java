package com.example.kitapgunlugum;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kitapgunlugum.api.MyBookResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class RecyclerViewMyBookAdapter extends RecyclerView.Adapter<RecyclerViewMyBookAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<MyBookResponse> myBookResponseArrayList;

    public RecyclerViewMyBookAdapter(Context context,ArrayList<MyBookResponse> myBookResponseArrayList)
    {
        layoutInflater = LayoutInflater.from(context);
        this.myBookResponseArrayList = myBookResponseArrayList;
    }


    @Override
    public RecyclerViewMyBookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.recycler_mybook_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewMyBookAdapter.ViewHolder holder, int position) {
        holder.lblPk.setText(myBookResponseArrayList.get(position).getPk());
        holder.lblBookName.setText(myBookResponseArrayList.get(position).getBook_name());
        holder.lblSayfa.setText(myBookResponseArrayList.get(position).getPage_number());
        holder.lblSubtitle.setText(myBookResponseArrayList.get(position).getSub_title());
        holder.lblBarkod.setText(myBookResponseArrayList.get(position).getBarcode());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView lblPk,lblBookName,lblSubtitle,lblSayfa,lblBarkod;
        public ViewHolder(View view)
        {
            super(view);

            lblPk = view.findViewById(R.id.txtPk);
            lblBookName = view.findViewById(R.id.txtBookName);
            lblSubtitle = view.findViewById(R.id.txtSubTitle);
            lblSayfa = view.findViewById(R.id.txtPageNumber);
            lblBarkod = view.findViewById(R.id.txtBarcode);

        }
    }

    /*
    List<MyBookResponse> myBookResponseArrayList;
    Context mContext;


    public RecyclerViewMyBookAdapter(Context context, List<MyBookResponse> arrayList)
    {
        myBookResponseArrayList = arrayList;
        mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView lblPk,lblBookName,lblSubtitle,lblSayfa,lblBarkod;
        public ViewHolder(View v)
        {
            super(v);

            lblPk = v.findViewById(R.id.txtPk);
            lblBookName = v.findViewById(R.id.txtBookName);
            lblSubtitle = v.findViewById(R.id.txtSubTitle);
            lblSayfa = v.findViewById(R.id.txtPageNumber);
            lblBarkod = v.findViewById(R.id.txtBarcode);


        }

    }


    @Override
    public RecyclerViewMyBookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_mybook_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.lblPk.setText(myBookResponseArrayList.get(position).getPk());
        holder.lblBookName.setText(myBookResponseArrayList.get(position).getBook_name());
        holder.lblSayfa.setText(myBookResponseArrayList.get(position).getPage_number());
        holder.lblSubtitle.setText(myBookResponseArrayList.get(position).getSub_title());
        holder.lblBarkod.setText(myBookResponseArrayList.get(position).getBarcode());
    }

    @Override
    public int getItemCount() {
        return myBookResponseArrayList.size();
    }
    */
}
