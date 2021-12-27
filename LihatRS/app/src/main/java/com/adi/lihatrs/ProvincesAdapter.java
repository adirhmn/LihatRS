package com.adi.lihatrs;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProvincesAdapter extends RecyclerView.Adapter<ProvincesAdapter.ProvincesViewHolder> {
    private List<Model.Provinces> listProvinces;

    public ProvincesAdapter(List<Model.Provinces> listProvinces) {
        this.listProvinces = listProvinces;
    }

    @NonNull
    @Override
    public ProvincesAdapter.ProvincesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_province, viewGroup, false);
        return new ProvincesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProvincesAdapter.ProvincesViewHolder holder, int position) {
        Model.Provinces province=listProvinces.get(position);
        holder.tvProvinceName.setText(province.getName());
        holder.pilihProvinsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.pilihProvinsi.getContext(), PilihKotaKab.class);
                intent.putExtra("name_province", province.getName());
                intent.putExtra("id_province", province.getId());
                holder.pilihProvinsi.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listProvinces.size();
    }

    public class ProvincesViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout pilihProvinsi;
        private TextView tvProvinceName;

        public ProvincesViewHolder(@NonNull View itemView) {
            super(itemView);

            pilihProvinsi=itemView.findViewById(R.id.pilih_provinsi);
            tvProvinceName=itemView.findViewById(R.id.tv_province_name);
        }
    }
}
