package com.badikirwan.dicoding.animeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_NAME = "extra_name";
    public static String EXTRA_PHOTO = "extra_photo";
    public static String EXTRA_EPISODE = "extra_episode";
    public static String EXTRA_DESKRIPSI = "extra_deskripsi";
    public static String EXTRA_VIEW_ANIME = "extra_view_anime";
    private ImageView imgPhoto;
    private TextView tvName, tvEpisode, tvDiskripsi, tvViewAnime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imgPhoto = (ImageView) findViewById(R.id.img_item_photo);
        tvName = (TextView) findViewById(R.id.tv_item_name);
        tvViewAnime = (TextView) findViewById(R.id.tv_view_anime);
        tvEpisode = (TextView) findViewById(R.id.tv_episode);
        tvDiskripsi = (TextView) findViewById(R.id.tv_deskripsi);

        String name = getIntent().getStringExtra(EXTRA_NAME);
            String viewanime = getIntent().getStringExtra(EXTRA_VIEW_ANIME);
        String photo = getIntent().getStringExtra(EXTRA_PHOTO);
        String episode = getIntent().getStringExtra(EXTRA_EPISODE);
        String deskripsi = getIntent().getStringExtra(EXTRA_DESKRIPSI);

        tvName.setText(name);
        tvViewAnime.setText(viewanime);
        tvDiskripsi.setText(deskripsi);
        tvEpisode.setText(episode);
        Glide.with(this)
                .load(photo)
                .override(350, 550)
                .into(imgPhoto);
    }
}
