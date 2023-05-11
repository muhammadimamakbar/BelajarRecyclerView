package com.imam2trk.belajarrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menambahkan data ke RecyclerView
        ArrayList<String> namaHewan = new ArrayList<>();
        namaHewan.add("Kuda");
        namaHewan.add("Sapi");
        namaHewan.add("Monyet");
        namaHewan.add("Kambing");
        namaHewan.add("Kucing");

        //set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, namaHewan);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        ((DividerItemDecoration) itemDecoration).setDrawable(ContextCompat.getDrawable(this, R.drawable.item_separator));
        recyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "Anda menekan " + adapter.getItem(position) +
                " pada baris ke " + position, Toast.LENGTH_SHORT).show();
    }
}