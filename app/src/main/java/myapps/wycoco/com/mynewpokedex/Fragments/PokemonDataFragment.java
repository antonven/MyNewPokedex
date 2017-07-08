package myapps.wycoco.com.mynewpokedex.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import myapps.wycoco.com.mynewpokedex.Models.PokemonDataModel;
import myapps.wycoco.com.mynewpokedex.Adapters.PokemonDataAdapter;
import myapps.wycoco.com.mynewpokedex.R;
import myapps.wycoco.com.mynewpokedex.Volley.VolleySingleton;

/**
 * A simple {@link Fragment} subclass.
 */
public class PokemonDataFragment extends Fragment {

    private String url = "http://pokeapi.co/api/v2/pokemon";

    RecyclerView recView;
    PokemonDataAdapter pokemonDataAdapter;
    RequestQueue requestQueue;
    ProgressBar progressBar;
    ArrayList<PokemonDataModel> pokemonsters = new ArrayList<>();

    public PokemonDataFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pokemon_data, container, false);

        progressBar = (ProgressBar)v.findViewById(R.id.progressBar);

        recView = (RecyclerView)v.findViewById(R.id.recView);
        JsonRequestObject();




        return v;
    }

    private void JsonRequestObject(){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            JSONArray jsonArray = response.getJSONArray("results");
                            String nxtUrl = response.getString("next");

                            for(int i = 0; i<jsonArray.length(); i++){
                                JSONObject pokemon = jsonArray.getJSONObject(i);
                                String pokeUrl = pokemon.getString("url");
                                Log.e("Kirsten", "naabot diri");
                                final PokemonDataModel pokemonDataModel = new PokemonDataModel();

                                pokemonDataModel.setPokeName(pokemon.getString("name").toUpperCase());

                                JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.GET, pokeUrl,
                                        new Response.Listener<JSONObject>() {
                                            @Override
                                            public void onResponse(JSONObject response) {
                                                try{
                                                    if(response != null)
                                                    progressBar.setVisibility(View.GONE);

                                                    JSONObject jsonObject = response.getJSONObject("sprites");
                                                    JSONArray jsonArray1 = response.getJSONArray("types");
                                                    String pokeImage = jsonObject.getString("front_default");
                                                    Log.e("Kirsten", "naabot diri2");
                                                    pokemonDataModel.setPokeImage(pokeImage);
                                                    pokemonDataModel.setPokeNo(response.getString("id"));
                                                    for (int o = 0; o < jsonArray1.length(); o++) {
                                                        JSONObject pokemonmon = jsonArray1.getJSONObject(o);

                                                        JSONObject jsonObject4 = pokemonmon.getJSONObject("type");
                                                        String pokeType = jsonObject4.getString("name").toUpperCase();
                                                        pokemonDataModel.setPokeType(pokeType);
                                                        Log.e("Me", pokemonDataModel.getPokeType());
                                                    }
                                                    pokemonDataModel.setPokeWeight(response.getString("weight"));
                                                    pokemonDataModel.setPokeHeight(response.getString("height"));
                                                    pokemonDataModel.setPokeVersion("");
                                                    Log.e("Kirsten", pokemonDataModel.getPokeImage());

                                                }catch (JSONException e){
                                                    e.printStackTrace();
                                                }
                                            }
                                        },
                                        new Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
//                                                Toast.makeText(getContext(), "There is no connection!", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                );
                                Log.e("Kirsten", "naabot diri");
                                VolleySingleton.getInstance().addToRequestQueue(jsonObjectRequest2);
                                pokemonsters.add(pokemonDataModel);
                                pokemonDataAdapter = new PokemonDataAdapter(getContext(), pokemonsters);
                                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                                recView.setLayoutManager(layoutManager);
                                recView.setItemAnimator(new DefaultItemAnimator());
                                recView.setAdapter(pokemonDataAdapter);

                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getContext(), "There is no connection!", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        VolleySingleton.getInstance().addToRequestQueue(jsonObjectRequest);
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));
    }

}
