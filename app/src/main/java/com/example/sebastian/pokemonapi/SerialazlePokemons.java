package com.example.sebastian.pokemonapi;

import com.example.sebastian.pokemonapi.Model.PokemonS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import pl.marchuck.pokeapi.model.Pokemon;

/**
 * Created by Sebastian on 2016-07-11.
 */
public class SerialazlePokemons implements Serializable  {
    Pokemon pokemon;

    public SerialazlePokemons(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public static void SavePokemon(Pokemon pokemon) {
        String fileName = pokemon.name;




        PokemonS p1 = new PokemonS(pokemon);

        try (
                FileOutputStream fs = new FileOutputStream(MainActivity.Path_to_Pokemons+fileName);
                ObjectOutputStream os = new ObjectOutputStream(fs);
        ) {
            os.writeObject(p1);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Zapisano Pokemona "+fileName);
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }


    public static void ReadPokemon(Pokemon pokemon)
    {
        String fileName = pokemon.name;

        PokemonS p1=  null;

        if( !new File(MainActivity.Path_to_Pokemons+fileName).exists())
        return;

        try(
                FileInputStream fis = new FileInputStream(MainActivity.Path_to_Pokemons+fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {

            p1 = (PokemonS) ois.readObject();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(p1 != null) {
            System.out.println("Wczytano dane o: ");
            System.out.println(p1.name + "");
        }
        else
            System.out.println("nie wyczytało");



    }
}


