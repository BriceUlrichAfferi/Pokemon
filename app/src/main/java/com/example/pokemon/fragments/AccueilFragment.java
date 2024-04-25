package com.example.pokemon.fragments;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pokemon.R;
import com.example.pokemon.adapter.OnPokemonClickListener;
import com.example.pokemon.adapter.PokemonCardAdapter;
import com.example.pokemon.data.Pokemon;
import com.example.pokemon.data.PokemonData;
import com.example.pokemon.databinding.FragmentAccueilBinding;


public class AccueilFragment extends Fragment {

        private FragmentAccueilBinding binding;
        private PokemonCardAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAccueilBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new PokemonCardAdapter(PokemonData.pokemons, new OnPokemonClickListener() {
            @Override
            public void onclick(Pokemon pokemon) {

                Bundle bundle = new Bundle();
                bundle.putSerializable(InformationFragment.KEY_POKEMON, pokemon);

                if (getContext() != null) {
                    NavHostFragment.findNavController(AccueilFragment.this)
                            .navigate(R.id.action_accueilFragment_to_InformationFragment, bundle);
                }

            }
        });

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerview.setAdapter(adapter);
        binding.recyclerview.addItemDecoration(new DividerItemDecoration(binding.recyclerview.getContext(), DividerItemDecoration.VERTICAL));

        binding.ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NavHostFragment.findNavController(AccueilFragment.this)
                        .navigate(R.id.action_accueilFragment_to_CreateFragment);


            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}