package com.example.giwangnuelsyaputri.tugas5;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ViewHolder> {
    Context context;
    List<ArtistModel> artistModels = new ArrayList<>();
    public ArtistAdapter(Context context, List<ArtistModel> tempatModels) {
        this.context = context;
        this.artistModels = tempatModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_list, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.onBind(artistModels.get(i));
    }

    @Override
    public int getItemCount() {
        return artistModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView ivImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.txt);
            ivImage = itemView.findViewById(R.id.img);
        }

        public void onBind(final ArtistModel playlist) {
            tvName.setText(playlist.getName());
            ivImage.setImageResource(playlist.getImage());
            itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(context, playlist.getName(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}

