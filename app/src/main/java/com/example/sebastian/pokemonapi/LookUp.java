package com.example.sebastian.pokemonapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sebastian.pokemonapi.Model.PokemonS;

import pl.marchuck.pokeapi.model.PokeDetail;
import pl.marchuck.pokeapi.model.Pokemon;

public class LookUp extends AppCompatActivity {
 TextView tx;
PokemonS pokemonS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_up);
        tx= (TextView)findViewById(R.id.textView);
        Intent i = getIntent();
        Bundle extras = i.getExtras();
if(extras!=null)
{
    pokemonS=extras.getParcelable("key");
    
    if(pokemonS!=null)
        PutDetalis(pokemonS);
}
        else 
{
    Toast.makeText(LookUp.this, "Bład podczas wczytywania", Toast.LENGTH_SHORT).show();
}
    



    










    }

    private void PutDetalis(PokemonS pokemon) {

        StringBuilder pokeInfo = new StringBuilder();
        pokeInfo.append("NAZWA :  " + pokemon.name + System.lineSeparator());

        pokeInfo.append("WZROST :  " + pokemon.height + System.lineSeparator());
        pokeInfo.append("WAGA :  " + pokemon.weight + System.lineSeparator());
        pokeInfo.append("GATUNEK :  " + pokemon.species + System.lineSeparator());
        pokeInfo.append("ATAK :  " + pokemon.attack + System.lineSeparator());
        pokeInfo.append("Pkt. Zdrowia  :" + pokemon.hp + System.lineSeparator());
        pokeInfo.append("OBRONA :  " + pokemon.defense + System.lineSeparator());
        pokeInfo.append("Szybkosc :  " + pokemon.speed + System.lineSeparator());
        pokeInfo.append("Pkt. Zdrowia :  " + pokemon.hp + System.lineSeparator());

        pokeInfo.append("Współczynnik wzrostu :  " + pokemon.growth_rate + System.lineSeparator());
        pokeInfo.append("Współczynnik szcześci:  " + pokemon.happiness + System.lineSeparator());
        pokeInfo.append("Stosunek samców do samic:  " + pokemon.male_female_ratio + System.lineSeparator());

       
        tx.setText(pokeInfo.toString());
    }}
