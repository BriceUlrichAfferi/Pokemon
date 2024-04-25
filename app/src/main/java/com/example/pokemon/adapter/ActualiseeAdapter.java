package com.example.pokemon.adapter;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemon.adapter.PokemonCardAdapter;
import com.example.pokemon.data.Pokemon;

import java.util.ArrayList;

public abstract class ActualiseeAdapter <T extends PokemonCardAdapter.PokemonViewHolder> extends RecyclerView.Adapter <T> {

            protected ArrayList<Pokemon>data = new ArrayList<>();

            public void refresh (ArrayList<Pokemon>data ){
                this.data.clear();
            this.data.addAll(data);
            this.notifyDataSetChanged();
            }
}
