package com.example.pokemon.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemon.R;
import com.example.pokemon.data.Pokemon;
import com.example.pokemon.databinding.ItemPokemonBinding;

import java.util.ArrayList;

public class PokemonCardAdapter extends ActualiseeAdapter<PokemonCardAdapter.PokemonViewHolder> {


    OnPokemonClickListener clickListener;
    public PokemonCardAdapter (ArrayList<Pokemon> data, OnPokemonClickListener clickListener){
        this.clickListener = clickListener;
        refresh(data);
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonViewHolder(ItemPokemonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon pokemon = data.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onclick(pokemon);
            }
        });

        holder.binding.profile.setImageDrawable(AppCompatResources.getDrawable(holder.itemView.getContext(), pokemon.getType().getCouverture()));
        holder.binding.name.setText(pokemon.getName());
        holder.binding.info.setText(holder.itemView.getContext().getString(
                R.string.information,
                pokemon.getName(),
                pokemon.getGeneration(),
                pokemon.getType()
        ));

    }



    @Override
    public int getItemCount() {
        return data.size();
    }


    static class PokemonViewHolder  extends RecyclerView.ViewHolder{

            ItemPokemonBinding binding;

        public PokemonViewHolder(ItemPokemonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
