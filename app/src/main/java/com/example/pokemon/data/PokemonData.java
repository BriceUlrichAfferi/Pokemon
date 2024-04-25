package com.example.pokemon.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PokemonData {

    private static Pokemon squirtle = new Pokemon ("Squirtle",1,Type.WATER  );
    private static Pokemon tranquill = new Pokemon("Tranquill", 5, Type.FLYING);
    private static Pokemon dartrix = new Pokemon("Dartrix", 7, Type.GRASS);
    private static Pokemon blastoise = new Pokemon("Blastoise", 1, Type.WATER);
    private static Pokemon shroodle = new Pokemon("Shroodle", 9, Type.POISON);

    private static Set <Pokemon> deletePokemon = new HashSet<>();

    public static ArrayList<Pokemon>pokemons = new ArrayList<Pokemon>(){
        {
            add(squirtle);
            add(tranquill);
            add(dartrix);
            add(blastoise);
            add(shroodle);

        }
    };

    public static void removePokemon(Pokemon pokemon) {
        pokemons.remove(pokemon);
    }

}

