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
        holder.districtNameTextView.setText(place.getDistrict().toString());
        holder.mandalNameTextView.setText(place.getMandal().toString());
        holder.villageNameTextView.setText(place.getVillage().toString());
        holder.survey_no_NameTextView.setText(place.getSurvey_no().toString());
        holder.khata_no_NameTextView.setText(place.getKhata_no().toString());
        holder.costTextView.setText(place.getCost().toString());
        holder.areaTextView.setText(place.getArea().toString());
        holder.ph_noTextView.setText(place.getPh_no().toString());
//        holder.placeNameTextView.setText(place.getPlace().toString());
//        holder.yearsTextView.setText(place.getYears().toString());
//        holder.installTextView.setText(place.getInstallations().toString());
//        holder.negTextView.setText(place.getNegotiation().toString());
//        holder.RotTextView.setText(place.getRot().toString());
        holder.soilTextView.setText(place.getSoil().toString());
        holder.watersourceTextView.setText(place.getWatersource().toString());
    }


    @Override
    public int getItemCount() {
        return places.size();
    }

     class PlaceViewHolder extends RecyclerView.ViewHolder {
        TextView districtNameTextView;
        TextView costTextView;
        TextView ph_noTextView;
        TextView areaTextView;
         TextView watersourceTextView;
         TextView mandalNameTextView;
         TextView soilTextView;
         TextView villageNameTextView;
         TextView survey_no_NameTextView;
         TextView khata_no_NameTextView;

        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);

            districtNameTextView = itemView.findViewById(R.id.district_unique);
            mandalNameTextView = itemView.findViewById(R.id.mandal_unique);
            villageNameTextView = itemView.findViewById(R.id.village_unique);
            survey_no_NameTextView = itemView.findViewById(R.id.survey_no_unique);
            khata_no_NameTextView = itemView.findViewById(R.id.khata_no_unique);
            costTextView = itemView.findViewById(R.id.cost_unique);
            areaTextView = itemView.findViewById(R.id.area_unique);
            ph_noTextView = itemView.findViewById(R.id.ph_no_unique);
            watersourceTextView = itemView.findViewById(R.id.watersource_unique);
            soilTextView = itemView.findViewById(R.id.soiltype_unique);
//            placeNameTextView = itemView.findViewById(R.id.place_unique);
//            RotTextView = itemView.findViewById(R.id.croprot_unique);
//            negTextView = itemView.findViewById(R.id.negotiation_unique);
//            installTextView = itemView.findViewById(R.id.installments_unique);
//            yearsTextView = itemView.findViewById(R.id.years_unique);

        }
    }
}

