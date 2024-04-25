package com.example.pokemon.data;

import java.io.Serializable;

public class Pokemon implements Serializable {

    private String name;
    private int generation;
    private Type type;

    public Pokemon (String name, int generation, Type type){
        this.name = name;
        this.generation = generation;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGeneration() {
        return generation;
    }

    public Type getType() {
        return type;
    }

}
