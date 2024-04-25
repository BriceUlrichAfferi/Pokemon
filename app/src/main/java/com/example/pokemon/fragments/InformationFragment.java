package com.example.pokemon.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pokemon.data.Pokemon;
import com.example.pokemon.data.PokemonData;
import com.example.pokemon.databinding.FragmentInformationBinding;

public class InformationFragment extends Fragment {

    public  static final String KEY_POKEMON = "POKEMON";
    private FragmentInformationBinding binding;

    private Pokemon getPokemon (){

        Bundle args = getArguments();
        if (args != null) {
            return (Pokemon) args.getSerializable(KEY_POKEMON);
        }
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentInformationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.imageViewProfile.setImageDrawable(AppCompatResources.getDrawable(getContext(), getPokemon().getType().getCouverture()));
        binding.textViewName.setText(getPokemon().getName());
        binding.textViewGeneration.setText(String.valueOf("Generation " +getPokemon().getGeneration()));

        toDelete();
    }

    private void toDelete() {
        binding.butonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pokemon currentPokemon = getPokemon();
                PokemonData.removePokemon(currentPokemon);

                back();
            }
        });
    }
    private void back() {

        NavHostFragment.findNavController(InformationFragment.this)
                .navigateUp();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding= null;
    }
}

