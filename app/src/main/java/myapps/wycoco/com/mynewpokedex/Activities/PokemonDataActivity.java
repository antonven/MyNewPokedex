//package myapps.wycoco.com.mynewpokedex.Activities;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.MotionEvent;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.android.volley.DefaultRetryPolicy;
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.Volley;
//import com.bumptech.glide.Glide;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//
//import myapps.wycoco.com.mynewpokedex.Adapters.PokemonSingleDataAdapter;
//import myapps.wycoco.com.mynewpokedex.Models.PokemonDataModel;
//import myapps.wycoco.com.mynewpokedex.R;
//import myapps.wycoco.com.mynewpokedex.Volley.VolleySingleton;
//
//
//public class PokemonDataActivity extends AppCompatActivity {
//
//    private String url = "http://pokeapi.co/api/v2/pokemon";
//    private static String TAG = PokedexActivity.class.getSimpleName();
//
//    TextView pokeNo, pokeName, pokeType, pokeWeight, pokeHeight, pokeVersion;
//    ImageView pokeImage;
//
//    RecyclerView recView2;
//    ProgressBar progressBar;
//    PokemonSingleDataAdapter pokemonAdapter;
//    RequestQueue requestQueue;
//    ArrayList<PokemonDataModel> pokemonsters = new ArrayList<>();
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pokemon_data2);
//
//        pokeNo = (TextView)findViewById(R.id.pokeNo);
//        pokeName = (TextView)findViewById(R.id.pokeName);
//        pokeImage = (ImageView)findViewById(R.id.pokeImage);
//        pokeType = (TextView)findViewById(R.id.pokeType);
//        pokeWeight = (TextView)findViewById(R.id.pokeWeight);
//        pokeHeight = (TextView)findViewById(R.id.pokeHeight);
//        pokeVersion = (TextView)findViewById(R.id.pokeVersion);
//
//
//        requestQueue = Volley.newRequestQueue(this);
//        recView2 = (RecyclerView)findViewById(R.id.recView2);
//        progressBar = (ProgressBar)findViewById(R.id.progressBar);
////        Intent intent = getIntent();
//        Bundle args = getIntent().getExtras();
//        String name = args.getString("pokeName");
//        String no = args.getString("pokeNo");
//        String image = args.getString("pokeImage");
//        String weight = args.getString("pokeWeight");
//        String height = args.getString("pokeHeight");
//        String type = args.getString("pokeType");
//        String ver =  args.getString("pokeVersion");
//
////        String id = intent.getStringExtra("pokeID");
////        int pokeID = intent.getIntExtra("pokeID", 0);
//
//        Glide.with(this).load(image).into(pokeImage);
//        pokeName.setText(name);
////        pokeNo.setText(no);
//        pokeType.setText(type);
//        pokeWeight.setText(weight + " kg");
//        pokeHeight.setText(height + " cm");
//        pokeVersion.setText(ver);
//
//
//
//
//        PokemonDataModel pm = new PokemonDataModel(no, name, image, type, weight, height, ver);
//        pokemonsters.add(pm);
////        Log.e("ASD", "nnaabot najod diri sa last");
////        pokemonAdapter = new PokemonSingleDataAdapter(getApplicationContext(), pokemonsters);
////        pokemonAdapter.notifyDataSetChanged();
////        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
////        recView2.setLayoutManager(lm);
////        recView2.setAdapter(pokemonAdapter);
////        JsonObjectRequest(pokeID);
//
//    }
//
//    private void JsonObjectRequest(final int pokeID){
////        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
////                new Response.Listener<JSONObject>() {
////                    @Override
////                    public void onResponse(JSONObject response) {
////
////                        try {
////                            JSONArray jsonArray = response.getJSONArray("results");
////                            for (int i = 0; i < jsonArray.length(); i++) {
////                                if (i == pokeID) {
////                                    JSONObject pokemon = jsonArray.getJSONObject(i);
////                                    String pokeURL = pokemon.getString("url");
////
////
////                                    final PokemonDataModel pokemonster = new PokemonDataModel();
////                                    pokemonster.setPokeName(pokemon.getString("name").toUpperCase());
////
////
////                                    JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.GET, pokeURL,
////                                            new Response.Listener<JSONObject>() {
////                                                @Override
////                                                public void onResponse(JSONObject response) {
////                                                    try {
////                                                        if(response != null)
////                                                            progressBar.setVisibility(View.GONE);
////
////                                                        Log.e("kirs", "naabot");
////                                                        JSONObject jsonObject2 = response.getJSONObject("sprites");
////                                                        JSONArray jsonArray1 = response.getJSONArray("types");
////                                                        String picUrl = jsonObject2.getString("front_default");
////                                                        pokemonster.setPokeHeight(response.getString("height"));
////                                                        pokemonster.setPokeWeight(response.getString("weight"));
////                                                        pokemonster.setPokeImage(picUrl);
////
////                                                        for (int o = 0; o < jsonArray1.length(); o++) {
////                                                            JSONObject pokemonmon = jsonArray1.getJSONObject(o);
////
////                                                            JSONObject jsonObject4 = pokemonmon.getJSONObject("type");
////                                                            String pokeType = jsonObject4.getString("name").toUpperCase();
////                                                            pokemonster.setPokeType(pokeType);
////                                                            Log.e("Me", pokemonster.getPokeType());
////                                                        }
////
////
////
////                                                    } catch (JSONException e) {
////                                                        e.printStackTrace();
////                                                    }
////                                                }
////                                            }, new Response.ErrorListener() {
////                                        @Override
////                                        public void onErrorResponse(VolleyError error) {
////                                        }
////                                    });
////                                    VolleySingleton.getInstance().addToRequestQueue(jsonObjectRequest2);
//
//
////                                }
////
////                            }
////                        }catch(JSONException e){
////                            e.printStackTrace();
////                        }
////
////                    }
////                },
////                new Response.ErrorListener() {
////                    @Override
////                    public void onErrorResponse(VolleyError error) {
////                        Toast.makeText(PokemonDataActivity.this, "oops", Toast.LENGTH_SHORT).show();
////                        Log.e("VOLLEY", "ERROR");
////                    }
////                }
////        );
////        VolleySingleton.getInstance().addToRequestQueue(jsonObjectRequest);
////        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
////                5000,
////                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
////                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
////        ));
//    }
//
//
//}
