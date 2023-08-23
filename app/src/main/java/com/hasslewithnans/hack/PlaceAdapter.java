package com.hasslewithnans.hack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ValueEventListener;
import com.google.firebase.inappmessaging.model.Button;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {
    private List<data> places;
    private OnItemClickListener listener;

    public PlaceAdapter(List<data> places, OnItemClickListener listener) {
        this.places = places;
        this.listener = listener;
    }
    public PlaceAdapter(List<data> places) {
        this.places = places;
    }



    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_design, parent, false);
        return new PlaceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        data place = places.get(position);
        holder.placeNameTextView.setText(place.getPlace().toString());


//        holder.placeCostTextView.setText(place.getCost().toString());
    }


    @Override
    public int getItemCount() {
        return places.size();
    }

     class PlaceViewHolder extends RecyclerView.ViewHolder {
        TextView placeNameTextView;
//        TextView costTextView;
//        TextView ph_noTextView;
//        TextView areaTextView;

        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            placeNameTextView = itemView.findViewById(R.id.place_unique);

//
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(places.get(position));

                    }
                }
            });
            View viewInformationButton = itemView.findViewById(R.id.view_information_button); // Assuming this is your button ID

            viewInformationButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(places.get(position));
                    }
                }
            }
            );
//

            //            placeDescriptionTextView = itemView.findViewById(R.id.placeDescriptionTextView);
        }
//    }
    }
}

