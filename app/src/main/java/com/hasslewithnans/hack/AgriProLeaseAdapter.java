package com.hasslewithnans.hack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AgriProLeaseAdapter extends RecyclerView.Adapter<AgriProLeaseAdapter.LeaseViewHolder> {
    private List<agripro_data> Leases;
    public AgriProLeaseAdapter(List<agripro_data> Leases) {
        this.Leases = Leases;
    }

    @NonNull
    @Override
    public LeaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_agripro_design, parent, false);
        return new LeaseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaseViewHolder holder, int position) {
        agripro_data Lease = Leases.get(position);
        holder.nTextView.setText(Lease.getItem());
        holder.qTextView.setText(Lease.getQuantity());
        holder.ph_noTextView.setText(Lease.getPhone_num());
        holder.brTextView.setText(Lease.getBuyrent());
        holder.cTextView.setText(Lease.getCost());
        holder.dTextView.setText(Lease.getDescription());
    }


    @Override
    public int getItemCount() {
        return Leases.size();
    }

    class LeaseViewHolder extends RecyclerView.ViewHolder {
        TextView nTextView;
        TextView qTextView;
        TextView ph_noTextView;
        TextView cTextView;
        TextView dTextView;
        TextView brTextView;


        public LeaseViewHolder(@NonNull View itemView) {
            super(itemView);
            nTextView = itemView.findViewById(R.id.cost_uniqueb);
            qTextView = itemView.findViewById(R.id.area_uniqueb);
            brTextView= itemView.findViewById(R.id.mandal_uniqueb);
            cTextView= itemView.findViewById(R.id.village_uniqueb);
            dTextView = itemView.findViewById(R.id.x_uniqueb);
            ph_noTextView = itemView.findViewById(R.id.ph_no_uniqueb);
//            watersourceTextView = itemView.findViewById(R.id.watersource_unique1);
//            LeaseNameTextView = itemView.findViewById(R.id.Lease_unique);
//            RotTextView = itemView.findViewById(R.id.croprot_unique);
//            negTextView = itemView.findViewById(R.id.negotiation_unique);
//            installTextView = itemView.findViewById(R.id.installments_unique);
//            yearsTextView = itemView.findViewById(R.id.years_unique);

        }
    }
}

