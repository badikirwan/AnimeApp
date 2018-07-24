package com.badikirwan.dicoding.animeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<AnimeModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rv_anime);
        recyclerView.setHasFixedSize(true);
        list = new ArrayList<>();
        list.addAll(AnimeData.getListData());

        showRecyclerCardView();
    }

    private void showRecyclerCardView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final AnimeAdapter animeAdapter = new AnimeAdapter(this);
        animeAdapter.setListAnime(list);
        recyclerView.setAdapter(animeAdapter);

        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {

            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedItem(list.get(position));
            }
        });
    }

    private void showSelectedItem(AnimeModel animeModel) {
        Intent moveData = new Intent(MainActivity.this, DetailActivity.class);
        moveData.putExtra(DetailActivity.EXTRA_NAME, animeModel.getName());
        moveData.putExtra(DetailActivity.EXTRA_PHOTO, animeModel.getPhoto());
        moveData.putExtra(DetailActivity.EXTRA_EPISODE, animeModel.getEpisode());
        moveData.putExtra(DetailActivity.EXTRA_DESKRIPSI, animeModel.getDeskripsi());
        moveData.putExtra(DetailActivity.EXTRA_VIEW_ANIME, animeModel.getViewAnime());
        startActivity(moveData);
    }
}
