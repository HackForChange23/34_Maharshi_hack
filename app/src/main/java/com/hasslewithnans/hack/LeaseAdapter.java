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

public class LeaseAdapter extends RecyclerView.Adapter<LeaseAdapter.LeaseViewHolder> {
    private List<Lease_data> Leases;
    public LeaseAdapter(List<Lease_data> Leases) {
        this.Leases = Leases;
    }

    @NonNull
    @Override
    public LeaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lease_design, parent, false);
        return new LeaseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaseViewHolder holder, int position) {
        Lease_data Lease = Leases.get(position);
        holder.districtNameTextView.setText(Lease.getDistrict().toString());
        holder.mandalNameTextView.setText(Lease.getMandal().toString());
        holder.villageNameTextView.setText(Lease.getVillage().toString());
        holder.survey_no_NameTextView.setText(Lease.getSurvey_no().toString());
        holder.khata_no_NameTextView.setText(Lease.getKhata_no().toString());
        holder.negTextView.setText(Lease.getNeg().toString());
        holder.areaTextView.setText(Lease.getArea().toString());
        holder.ph_noTextView.setText(Lease.getPh_no().toString());
//        holder.LeaseNameTextView.setText(Lease.getLease().toString());
//        holder.yearsTextView.setText(Lease.getYears().toString());
//        holder.installTextView.setText(Lease.getInstallations().toString());
//        holder.negTextView.setText(Lease.getNegotiation().toString());
//        holder.RotTextView.setText(Lease.getRot().toString());
        holder.watersourceTextView.setText(Lease.getWatersource().toString());
    }


    @Override
    public int getItemCount() {
        return Leases.size();
    }

    class LeaseViewHolder extends RecyclerView.ViewHolder {
        TextView districtNameTextView;
        TextView negTextView;
        TextView ph_noTextView;
        TextView areaTextView;
        TextView watersourceTextView;
        TextView mandalNameTextView;
        TextView soilTextView;
        TextView villageNameTextView;
        TextView survey_no_NameTextView;
        TextView khata_no_NameTextView;

        public LeaseViewHolder(@NonNull View itemView) {
            super(itemView);

            districtNameTextView = itemView.findViewById(R.id.district_unique1);
            mandalNameTextView = itemView.findViewById(R.id.mandal_unique1);
            villageNameTextView = itemView.findViewById(R.id.village_unique1);
            survey_no_NameTextView = itemView.findViewById(R.id.survey_no_unique1);
            khata_no_NameTextView = itemView.findViewById(R.id.khata_no_unique1);
            negTextView = itemView.findViewById(R.id.neg_unique);
            areaTextView = itemView.findViewById(R.id.area_unique1);
            ph_noTextView = itemView.findViewById(R.id.ph_no_unique1);
            watersourceTextView = itemView.findViewById(R.id.watersource_unique1);
//            LeaseNameTextView = itemView.findViewById(R.id.Lease_unique);
//            RotTextView = itemView.findViewById(R.id.croprot_unique);
//            negTextView = itemView.findViewById(R.id.negotiation_unique);
//            installTextView = itemView.findViewById(R.id.installments_unique);
//            yearsTextView = itemView.findViewById(R.id.years_unique);

        }
    }
}

