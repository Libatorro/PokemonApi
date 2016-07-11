
package com.example.sebastian.pokemonapi.Model;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.sebastian.pokemonapi.LookUp;
import com.example.sebastian.pokemonapi.R;

import pl.marchuck.pokeapi.PokemonGET;
import pl.marchuck.pokeapi.interfaces.PokeReceiver;
import pl.marchuck.pokeapi.model.Pokemon;

public class ShearhActivity extends AppCompatActivity {

    RadioButton rID,rName;
    EditText editText;
    private Integer Pokemon_ID;
    private PokeReceiver<Pokemon> pokemonPokeReceiver;
    private String Name_for_seek;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shearh);



        rID = (RadioButton)findViewById(R.id.radioButton);
        rName = (RadioButton)findViewById(R.id.radioButton2);
        editText = (EditText)findViewById(R.id.EditText);


        rID.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rName.setChecked(false);
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            }
        });


        rName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rID.setChecked(false);
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
            }
        });

        pokemonPokeReceiver = new PokeReceiver<Pokemon>() {
            @Override
            public void onReceived(final Pokemon pokemon) {


    if(rID.isChecked())
    {
        Toast.makeText(ShearhActivity.this, "powinoo szukdfgdfgac", Toast.LENGTH_SHORT).show();

        AlertDialog.Builder builder = new AlertDialog.Builder(getApplication());
        builder.setTitle("Znaleziono Pokemona");
        LinearLayout layout = new LinearLayout(getApplication());
        layout.setOrientation(LinearLayout.VERTICAL);
        builder.setView(layout);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent i = new Intent(getApplication(), LookUp.class);
                Bundle args = new Bundle();
                args.putParcelable("key", new PokemonS(pokemon));

                i.putExtra("key",args);

                startActivity(i);


                }

        });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

        builder.show();




    }




            }
        };


    }



    public void szukaj(View w )
    {

        if(rID.isChecked())
        {   Pokemon_ID = Integer.parseInt(String.valueOf(editText.getText()));

            Toast.makeText(ShearhActivity.this, "powinoo szukac", Toast.LENGTH_SHORT).show();
            runOnUiThread(new Runnable() {
                public void run() {


                    new PokemonGET().singlePoke(Pokemon_ID, pokemonPokeReceiver);

                }

            });



        }

        if(rName.isChecked())
        {
            Toast.makeText(ShearhActivity.this, "Api z którego korzystam, nie działą zbyt szybko wiecj szukanie może troche potrwać  ", Toast.LENGTH_SHORT).show();
            Name_for_seek= String.valueOf(editText.getText());

            runOnUiThread(new Runnable() {
                public void run() {

                    for (int i = 0; i <720 ; i++) {
                        new PokemonGET().singlePoke(i, pokemonPokeReceiver);

                    }


                }

            });




        }







    }













}
