package com.example.kitapgunlugum;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kitapgunlugum.api.MyBookResponse;

import java.util.List;

public class MyBookAdapter extends RecyclerView.Adapter<MyBookAdapter.MyviewHolder> {

    Context context;
    List<MyBookResponse> myBookResponseList;

    public MyBookAdapter(Context context,List<MyBookResponse> myBookResponseList)
    {
        this.context = context;
        this.myBookResponseList = myBookResponseList;
    }

    public void setBookList(List<MyBookResponse> myBookResponseList)
    {
        this.myBookResponseList = myBookResponseList;
        notifyDataSetChanged();
    }

    @Override
    public MyBookAdapter.MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_mybook_item,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyBookAdapter.MyviewHolder holder, int position) {
        holder.lblPk.setText(myBookResponseList.get(position).getPk().toString());
        holder.lblBookName.setText(myBookResponseList.get(position).getBookName());
        holder.lblBarcode.setText(myBookResponseList.get(position).getBarcode());
    }

    @Override
    public int getItemCount() {
        if (myBookResponseList != null)
        {
            return myBookResponseList.size();
        }
        return 0;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder
    {
        TextView lblPk,lblBookName,lblBarcode;

        public MyviewHolder(View view)
        {
            super(view);
            lblPk = view.findViewById(R.id.txtPk);
            lblBookName = view.findViewById(R.id.txtBookName);
            lblBarcode = view.findViewById(R.id.txtBarcode);
        }
    }
}
