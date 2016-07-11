package com.example.sebastian.pokemonapi;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import pl.marchuck.pokeapi.PokemonGET;
import pl.marchuck.pokeapi.interfaces.PokeReceiver;
import pl.marchuck.pokeapi.model.PokeDetail;
import pl.marchuck.pokeapi.model.Pokemon;

public class PreViewPokemons extends AppCompatActivity {

    PokeReceiver<Pokemon> pokemonPokeReceiver;
    ArrayList<Pokemon> pokelist;
    int Pokemon_ID = 1;
    TextView PokeMon_Detalis;
    private Toolbar toolbar;
    private boolean LOSOWA_KOLEJNOSC = false;
    ListView historyList;
    ArrayAdapter<String> Adapter;
    private ArrayList<String> PokeNameList;
    boolean Ones=true;
    View parentLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_view_pokemons);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        parentLayout = findViewById(R.id.lay);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pokelist.size() > 0) {
                    if (!LOSOWA_KOLEJNOSC)
                        Pokemon_ID++;
                    else
                        Pokemon_ID=new Random().nextInt(720);

                } getPokemon(Pokemon_ID);





                historyList.setVisibility(View.GONE);
                PokeMon_Detalis.setVisibility(View.VISIBLE);

if(Ones)
                Snackbar.make(view, "Następny Pokemon", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            Ones=false;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            LOSOWA_KOLEJNOSC = true;

            return true;
        }
        if (id == R.id.action_history) {


            historyList.setVisibility(View.VISIBLE);
            PokeMon_Detalis.setVisibility(View.GONE);

            Snackbar.make(parentLayout, "Kliknij aby wyswietlic , przytrzymaj aby zapisać", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();


            return true;
        }




        return super.onOptionsItemSelected(item);
    }

    private void getPokemon(int pokemon_id) {


        runOnUiThread(new Runnable() {
            public void run() {


                new PokemonGET().singlePoke(Pokemon_ID, pokemonPokeReceiver);

            }

        });


    }

    private void PutDetalis(Pokemon pokemon) {

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

        for (PokeDetail x : pokemon.abilities)
            pokeInfo.append("Umiejętności  : " + x.name + System.lineSeparator());

        for (PokeDetail x : pokemon.sprites)
            pokeInfo.append("SPRITES  : " + x.name + System.lineSeparator());


        for (PokeDetail x : pokemon.descriptions)
            pokeInfo.append("DESCRYTPIONS  : " + x.name + System.lineSeparator());

        PokeMon_Detalis.setText(pokeInfo.toString());
    }

    private void init() {

        historyList = (ListView)findViewById(R.id.listView);



        historyList.setVisibility(View.GONE);
        PokeNameList= new ArrayList<String>();
        PokeMon_Detalis = (TextView) findViewById(R.id.PokemonStaff);
        pokelist = new ArrayList<>();
        Adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,PokeNameList);
        historyList.setAdapter(Adapter);
        pokemonPokeReceiver = new PokeReceiver<Pokemon>() {
            @Override
            public void onReceived(Pokemon pokemon) {

                pokelist.add(pokemon);
                PokeNameList.add(pokemon.name);

                Toast.makeText(PreViewPokemons.this, "Wczytano " + pokemon.name, Toast.LENGTH_SHORT).show();
                PutDetalis(pokemon);
                Adapter.notifyDataSetChanged();

            }
        };



        historyList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                SerialazlePokemons.SavePokemon(pokelist.get(position));
                SerialazlePokemons.ReadPokemon(pokelist.get(position));


                Snackbar.make(view, "Zapisano Pokemona"+pokelist.get(position).name, Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();

                return true;
            }
        });


        getPokemon(Pokemon_ID);

        historyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                PutDetalis(pokelist.get(position));
                historyList.setVisibility(View.GONE);
                PokeMon_Detalis.setVisibility(View.VISIBLE);



            }
        });

    }


}
