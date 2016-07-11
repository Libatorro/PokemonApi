package com.example.sebastian.pokemonapi;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sebastian.pokemonapi.Model.ShearhActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import pl.marchuck.pokeapi.PokemonGET;
import pl.marchuck.pokeapi.interfaces.PokeReceiver;
import pl.marchuck.pokeapi.model.Pokemon;

public class MainActivity extends AppCompatActivity {
    public  static  String Path_to_Pokemons=Environment.getExternalStorageDirectory().toString() + "/PokemonApi/SavedPokemons/";
//ListView pokeList;
//    ListAdapter Adapter;
//     HashSet<Pokemon> pokelist;
//    ArrayList<String> NAMES;
//    int licznik=0;
//    PokeReceiver<Pokemon> pokemonPokeReceiver;
//    List iDs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        createDirectory();
//pokelist= new HashSet<Pokemon>();
//NAMES = new ArrayList<>();
//// pokeList = (ListView)findViewById(R.id.listView);
//       iDs = new ArrayList<>(); for(int j=0;j<20;j++) iDs.add(j);
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//builder.setTitle("ładowanie Pokemonow");
//
//final ProgressBar progressBar= new ProgressBar(this);
//builder.setView(progressBar);
//
//        pokemonPokeReceiver = new PokeReceiver<Pokemon>() {
//            @Override
//            public void onReceived(Pokemon pokemon) {
//
//                 System.out.println((licznik++)+"  "+pokemon.name +" ");
//                pokelist.add(pokemon);
//                SerialazlePokemons.SavePokemon(pokemon);
//
//
//
//            }
//        };


    }


public void PreView(View v)
{

    Intent PreView = new Intent(this, PreViewPokemons.class);
    startActivity(PreView);

}

    public void seekforPoke(View view)
    {


        Intent i = new Intent(this,ShearhActivity.class);
        startActivity(i);



    }



//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // Start thread with low priority.
//                for (int i = 0; i <150 ; i++) {
//                    System.out.println("asdadasd");
//                    new PokemonGET().singlePoke(i, pokemonPokeReceiver);
//                }
//
//            }
//        }).start();





//
//        runOnUiThread(new Runnable() {
//            public void run() {
//                for (int i = 0; i <10 ; i++) {
//                 //   System.out.println(""+licznik++);
//                new PokemonGET().singlePoke(i,pokemonPokeReceiver);
//
//                }
//            }
//        });


//    }
//public void sout(View v)
//{
//
//
//    Toast.makeText(MainActivity.this, "asdasd"+pokelist.size(), Toast.LENGTH_SHORT).show();
//    for (Pokemon x : pokelist)
//        NAMES.add(x.name);
//
//
//    Adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, NAMES);
//
//    pokeList.setAdapter(Adapter);
//
//
//
//
//}
//
    public void createDirectory()
        {
            new File(Environment.getExternalStorageDirectory().toString() + "/PokemonApi/SavedPokemons/").mkdirs();



        }

}
