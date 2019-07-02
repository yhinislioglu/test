package com.example.kitapgunlugum;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kitapgunlugum.api.MyBookResponse;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewMyBookAdapter extends RecyclerView.Adapter<RecyclerViewMyBookAdapter.ViewHolder> {
    ArrayList<MyBookResponse> myBookResponseArrayList;
    Context mContext;
    protected ItemListener mlistener;

    public RecyclerViewMyBookAdapter(Context context, ArrayList<MyBookResponse> arrayList,ItemListener listener)
    {
        myBookResponseArrayList = arrayList;
        mContext = context;
        mlistener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView lblPk,lblBookName,lblSubtitle,lblSayfa,lblBarkod;
        MyBookResponse myBookResponse;
        public ViewHolder(View v)
        {
            super(v);

            v.setOnClickListener(this);
            lblPk = v.findViewById(R.id.txtPk);
            lblBookName = v.findViewById(R.id.txtBookName);
            lblSubtitle = v.findViewById(R.id.txtSubTitle);
            lblSayfa = v.findViewById(R.id.txtPageNumber);
            lblBarkod = v.findViewById(R.id.txtBarcode);


        }

        public void setData(MyBookResponse myBookResponses)
        {
            this.myBookResponse = myBookResponses;

            lblPk.setText(myBookResponses.getPk());
            lblBookName.setText(myBookResponses.getBook_name());
            lblSubtitle.setText(myBookResponses.getSub_title());
            lblSayfa.setText(myBookResponses.getPage_number());
            lblBarkod.setText(myBookResponses.getBarcode());
        }

        @Override
        public void onClick(View v) {
            if (mlistener != null)
            {
                mlistener.onItemClick(myBookResponse);
            }
        }
    }


    @Override
    public RecyclerViewMyBookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(myBookResponseArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return myBookResponseArrayList.size();
    }

    public interface ItemListener {
        void onItemClick(MyBookResponse item);
    }
}
