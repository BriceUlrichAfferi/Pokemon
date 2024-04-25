package com.example.pokemon.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pokemon.R;
import com.example.pokemon.data.Pokemon;
import com.example.pokemon.data.PokemonData;
import com.example.pokemon.data.Type;
import com.example.pokemon.databinding.FragmentCreateBinding;
import com.example.pokemon.databinding.FragmentInformationBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class CreateFragment extends Fragment {


    private FragmentCreateBinding binding;

   private Pokemon getPokemon (){
       try {
           return (Pokemon) getArguments().getSerializable(InformationFragment.KEY_POKEMON);
       } catch (Exception e){
           return null;
       }
   }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentCreateBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.choixType.setMinValue(1);
        binding.choixType.setMaxValue(getTypes().size());
        binding.choixType.setValue(1);
        binding.choixType.setWrapSelectorWheel(false);
        binding.choixType.setDisplayedValues(getTypes().toArray(new String[0]));

        binding.creer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verifyAndCreatePokemon()) {
                    NavHostFragment.findNavController(CreateFragment.this).navigateUp();
                }
            }
        });
    }

    private List<String> getTypes() {
        ArrayList<String> result = new ArrayList<>();
        for (Type type : Type.values()){
            result.add(type.name());
        }
        return result;
    }

    private boolean verifyAndCreatePokemon() {
        String name = binding.champNom.getText().toString();
        if (name.isBlank()) {
            Snackbar.make(
                    getView(),
                    "The name must not be empty",
                    Snackbar.LENGTH_LONG
            ).setAnchorView(R.id.creer).show();
            return false;
        }

        Type type= Type.values()[binding.choixType.getValue() - 1];

        int generation;
        try {
            generation = Integer.parseInt(binding.champGeneration.getText().toString());
        } catch (NumberFormatException e) {
            Snackbar.make(
                    getView(),
                    "The generation is not valid",
                    Snackbar.LENGTH_LONG
            ).setAnchorView(R.id.creer).show();
            return false;
        }

        PokemonData.pokemons.remove(getPokemon());
        PokemonData.pokemons.add(new Pokemon(
                name,
                generation,
                type
        ));

        return true;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}