package com.badikirwan.dicoding.animeapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.CardViewHolder> {

    private ArrayList<AnimeModel> listAnime;
    private Context context;

    public AnimeAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<AnimeModel> getListAnime() {
        return listAnime;
    }

    public void setListAnime(ArrayList<AnimeModel> listAnime) {
        this.listAnime = listAnime;
    }

    @Override
    public AnimeAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_anime, parent,false);
        CardViewHolder cardViewHolder = new CardViewHolder(view);
        return cardViewHolder;
    }

    @Override
    public void onBindViewHolder(final AnimeAdapter.CardViewHolder holder, int position) {
        final AnimeModel animeModel = getListAnime().get(position);
        Glide.with(context)
                .load(animeModel.getPhoto())
                .override(350, 550)
                .into(holder.imgPhoto);
        holder.tvName.setText(animeModel.getName());
        holder.tvViewAnime.setText(animeModel.getViewAnime());
        holder.btnDetail.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent moveData = new Intent(context, DetailActivity.class);
                moveData.putExtra(DetailActivity.EXTRA_NAME, animeModel.getName());
                moveData.putExtra(DetailActivity.EXTRA_PHOTO, animeModel.getPhoto());
                moveData.putExtra(DetailActivity.EXTRA_EPISODE, animeModel.getEpisode());
                moveData.putExtra(DetailActivity.EXTRA_DESKRIPSI, animeModel.getDeskripsi());
                moveData.putExtra(DetailActivity.EXTRA_VIEW_ANIME, animeModel.getViewAnime());
                context.startActivity(moveData);
            }
        }));

        holder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Ini adalah anime fovorite saya");
                shareIntent.putExtra(Intent.EXTRA_TEXT, animeModel.getName());
                shareIntent.setType("text/plain");
                context.startActivity(shareIntent);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListAnime().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;
        TextView tvName, tvViewAnime;
        Button btnShare, btnDetail;

        public CardViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView) itemView.findViewById(R.id.img_item_photo);
            tvName = (TextView) itemView.findViewById(R.id.tv_item_name);
            tvViewAnime = (TextView) itemView.findViewById(R.id.tv_item_view);
            btnShare = (Button) itemView.findViewById(R.id.btn_set_share);
            btnDetail = (Button) itemView.findViewById(R.id.btn_set_detail);
        }
    }

    public static class CustomOnItemClickListener implements View.OnClickListener {

        private int position;
        private OnItemClickCallback onItemClickCallback;

        private CustomOnItemClickListener(int position, OnItemClickCallback onItemClickCallback) {
            this.position = position;
            this.onItemClickCallback = onItemClickCallback;
        }

        @Override
        public void onClick(View view) {
            onItemClickCallback.onItemClicked(view, position);
        }

        public interface OnItemClickCallback {
            void onItemClicked(View view, int position);
        }
    }
}
