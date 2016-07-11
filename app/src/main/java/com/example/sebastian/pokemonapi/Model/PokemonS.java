package com.example.sebastian.pokemonapi.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pl.marchuck.pokeapi.model.Evolution;
import pl.marchuck.pokeapi.model.Move;
import pl.marchuck.pokeapi.model.PokeDetail;
import pl.marchuck.pokeapi.model.Pokemon;

/**
 * Created by Sebastian on 2016-07-11.
 */
public class PokemonS implements Serializable,Parcelable{



    public Integer attack;
    public Integer catch_rate;
    public String created;
    public Integer defense;

    public Integer egg_cycles;

    public String ev_yield;

    public Integer exp;
    public String growth_rate;
    public Integer happiness;
    public String height;
    public Integer hp;
    public String male_female_ratio;
    public String modified;

    public String name;
    public Integer national_id;
    public Integer pkdx_id;
    public String resource_uri;
    public Integer sp_atk;
    public Integer sp_def;
    public String species;
    public Integer speed;

    public Integer total;

    public PokemonS(Pokemon pokemon) {
        this.attack = pokemon.attack;
        this.catch_rate = pokemon.catch_rate;
        this.created = pokemon.created;
        this.defense = pokemon.defense;
        this.egg_cycles = pokemon.egg_cycles;
        this.ev_yield = pokemon.ev_yield;
        this.exp = pokemon.exp;
        this.growth_rate = pokemon.growth_rate;
        this.happiness = pokemon.happiness;
        this.height = pokemon.height;
        this.hp = pokemon.hp;
        this.male_female_ratio = pokemon.male_female_ratio;
        this.modified = pokemon.modified;
        this.name = pokemon.name;
        this.national_id = pokemon.national_id;
        this.pkdx_id = pokemon.pkdx_id;
        this.resource_uri = pokemon.resource_uri;
        this.sp_atk = pokemon.sp_atk;
        this.sp_def = pokemon.sp_def;
        this.species = pokemon.species;
        this.speed = pokemon.speed;
        this.total = pokemon.total;
        this.weight = pokemon.weight;
    }

    public String weight;

    protected PokemonS(Parcel in) {
        created = in.readString();
        ev_yield = in.readString();
        growth_rate = in.readString();
        height = in.readString();
        male_female_ratio = in.readString();
        modified = in.readString();
        name = in.readString();
        resource_uri = in.readString();
        species = in.readString();
        weight = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(created);
        dest.writeString(ev_yield);
        dest.writeString(growth_rate);
        dest.writeString(height);
        dest.writeString(male_female_ratio);
        dest.writeString(modified);
        dest.writeString(name);
        dest.writeString(resource_uri);
        dest.writeString(species);
        dest.writeString(weight);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PokemonS> CREATOR = new Creator<PokemonS>() {
        @Override
        public PokemonS createFromParcel(Parcel in) {
            return new PokemonS(in);
        }

        @Override
        public PokemonS[] newArray(int size) {
            return new PokemonS[size];
        }
    };
}
