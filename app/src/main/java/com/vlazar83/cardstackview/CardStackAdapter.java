package com.vlazar83.cardstackview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import static java.util.Collections.emptyList;

public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder> {

    private List<Spot> spots;

    CardStackAdapter(){
        spots = emptyList();
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    public List<Spot> getSpots(){
        return this.spots;
    }

    @NonNull
    @Override
    public CardStackAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItemView = inflater.inflate(R.layout.item_spot, parent, false);
        return new ViewHolder(listItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardStackAdapter.ViewHolder holder, int position) {
        Spot spot = spots.get(position);
        holder.name.setText(spot.getId() + " " + spot.getName());
        holder.city.setText(spot.getCity());
        Glide.with(holder.image)
                .load(spot.getUrl())
                .into(holder.image);
        holder.itemView.setOnClickListener(v ->
                Toast.makeText(v.getContext(), spot.getName(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return spots.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(@NonNull View view) {
            super(view);
        }

        TextView name = super.itemView.findViewById(R.id.item_name);
        TextView city = super.itemView.findViewById(R.id.item_city);
        ImageView image = super.itemView.findViewById(R.id.item_image);
    }

}
