package com.example.kitapgunlugum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.pusher.pushnotifications.PushNotifications;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemListener {

    RecyclerView recyclerView;
    ArrayList<DataModel> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PushNotifications.start(getApplicationContext(), "a7bc7826-c953-4cbd-8afa-4451d01473e2");
        PushNotifications.addDeviceInterest("hello");

        recyclerView = findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();
        arrayList.add(new DataModel("Kitaplarım",R.drawable.openbook,"#b36a53"));
        arrayList.add(new DataModel("Ajanda",R.drawable.agenda,"#e6e6e6"));
        arrayList.add(new DataModel("Günlük",R.drawable.diary,"#9dbbd3"));
        arrayList.add(new DataModel("Raporlar",R.drawable.chemistry,"#f7d460"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,arrayList,this);
        recyclerView.setAdapter(adapter);

        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this,500);
        recyclerView.setLayoutManager(layoutManager);



    }

    @Override
    public void onItemClick(DataModel item) {
        Intent intent = new Intent();
        switch (item.text)
        {
            case "Kitaplarım" :
                intent = new Intent(MainActivity.this,MyBookActivity.class);
                break;
            case "Ajanda" :
                intent = new Intent(MainActivity.this,MyBookActivity.class);
                break;
            case "Günlük" :
                intent = new Intent(MainActivity.this,MyBookActivity.class);
                break;
            case "Raporlar" :
                intent = new Intent(MainActivity.this,MyBookActivity.class);
                break;

        }


        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        //Toast.makeText(getApplicationContext(),item.text+" tıklandı.",Toast.LENGTH_LONG).show();
    }
}


