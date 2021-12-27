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

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder> {
    private List<Model.Cities> listCity;
    private String id_province;

    public CitiesAdapter(List<Model.Cities> listCity, String id_province) {
        this.listCity = listCity;
        this.id_province=id_province;
    }

    @NonNull
    @Override
    public CitiesAdapter.CitiesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cities, viewGroup, false);
        return new CitiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CitiesAdapter.CitiesViewHolder holder, int position) {
        Model.Cities city=listCity.get(position);
        holder.tvCitiesName.setText(city.getName());
        holder.pilihKota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.pilihKota.getContext(), DaftarRS.class);
                intent.putExtra("name_city", city.getName());
                intent.putExtra("id_city", city.getId());
                intent.putExtra("id_province", id_province);
                holder.pilihKota.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listCity.size();
    }

    public class CitiesViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout pilihKota;
        private TextView tvCitiesName;

        public CitiesViewHolder(@NonNull View itemView) {
            super(itemView);

            pilihKota=itemView.findViewById(R.id.pilih_kota);
            tvCitiesName=itemView.findViewById(R.id.tv_city_name);
        }
    }
}
