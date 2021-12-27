package com.adi.lihatrs;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HospitalsAdapter extends RecyclerView.Adapter<HospitalsAdapter.HospitalsViewHolder> {
    private List<Model.Hospitals> listHospitals;

    public HospitalsAdapter(List<Model.Hospitals> listHospitals) {
        this.listHospitals = listHospitals;
    }

    @NonNull
    @Override
    public HospitalsAdapter.HospitalsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_hospital, viewGroup, false);
        return new HospitalsAdapter.HospitalsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalsAdapter.HospitalsViewHolder holder, int position) {
        Model.Hospitals hospitals=listHospitals.get(position);
        holder.tvNameRS.setText(hospitals.getName());
        holder.tvAddressRS.setText(hospitals.getAddress());
        holder.tvTelpRS.setText(hospitals.getPhone());
        holder.cvPilihRS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.cvPilihRS.getContext(), DetailRS.class);
                intent.putExtra("id", hospitals.getId());
                intent.putExtra("name", hospitals.getName());
                intent.putExtra("address", hospitals.getAddress());
                intent.putExtra("telp", hospitals.getPhone());
                intent.putExtra("available", hospitals.getAvailable_beds().get(0).getAvailable());
                intent.putExtra("bed_class", hospitals.getAvailable_beds().get(0).getBed_class());
                intent.putExtra("room_name", hospitals.getAvailable_beds().get(0).getRoom_name());
                intent.putExtra("last_update", hospitals.getAvailable_beds().get(0).getInfo());
                holder.cvPilihRS.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHospitals.size();
    }

    public class HospitalsViewHolder extends RecyclerView.ViewHolder {
        private CardView cvPilihRS;
        private TextView tvNameRS,tvAddressRS, tvTelpRS;

        public HospitalsViewHolder(@NonNull View itemView) {
            super(itemView);

            cvPilihRS=itemView.findViewById(R.id.pilih_rs);
            tvNameRS=itemView.findViewById(R.id.tv_name_rs);
            tvAddressRS=itemView.findViewById(R.id.tv_address_rs);
            tvTelpRS=itemView.findViewById(R.id.tv_telp_rs);
        }
    }
}
