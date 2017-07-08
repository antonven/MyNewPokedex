package myapps.wycoco.com.mynewpokedex.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import myapps.wycoco.com.mynewpokedex.Adapters.PokemonSingleDataAdapter;
import myapps.wycoco.com.mynewpokedex.Models.PokemonDataModel;
import myapps.wycoco.com.mynewpokedex.R;

public class PokemonActivity extends AppCompatActivity {

    private String url = "http://pokeapi.co/api/v2/pokemon";
    private static String TAG = PokedexActivity.class.getSimpleName();

    TextView pokeNo, pokeName, pokeType, pokeWeight, pokeHeight, pokeVersion;
    ImageView pokeImage;

    RecyclerView recView2;
    ProgressBar progressBar;
    PokemonSingleDataAdapter pokemonAdapter;
    RequestQueue requestQueue;
    ArrayList<PokemonDataModel> pokemonsters = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_data2);

        pokeNo = (TextView) findViewById(R.id.pokeNo);
        pokeName = (TextView) findViewById(R.id.pokeName);
        pokeImage = (ImageView) findViewById(R.id.pokeImage);
        pokeType = (TextView) findViewById(R.id.pokeType);
        pokeWeight = (TextView) findViewById(R.id.pokeWeight);
        pokeHeight = (TextView) findViewById(R.id.pokeHeight);
        pokeVersion = (TextView) findViewById(R.id.pokeVersion);


        requestQueue = Volley.newRequestQueue(this);
        recView2 = (RecyclerView) findViewById(R.id.recView2);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Intent intent = getIntent();
        Bundle args = getIntent().getExtras();
        String name = args.getString("pokeName");
        String no = args.getString("pokeNo");
        String image = args.getString("pokeImage");
        String weight = args.getString("pokeWeight");
        String height = args.getString("pokeHeight");
        String type = args.getString("pokeType");
        String ver = args.getString("pokeVersion");

//        String id = intent.getStringExtra("pokeID");
//        int pokeID = intent.getIntExtra("pokeID", 0);


        Glide.with(this).load(image).into(pokeImage);
        pokeName.setText(name);
//        pokeNo.setText(no);
        pokeType.setText(type);
        pokeWeight.setText(weight + " kg");
        pokeHeight.setText(height + " cm");
        pokeVersion.setText(image);

    }
}
