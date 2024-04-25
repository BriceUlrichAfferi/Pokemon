package com.example.pokemon.data;


import androidx.annotation.DrawableRes;

import com.example.pokemon.R;

public enum Type {

    WATER, FLYING, GRASS, POISON;

    public @DrawableRes int getCouverture(){
        return switch (this){
            case WATER -> R.drawable.pkm_water;
            case FLYING -> R.drawable.pkm_flying;
            case GRASS -> R.drawable.pkm_grass;
            case POISON -> R.drawable.pkm_poison;

        };
    }

}
