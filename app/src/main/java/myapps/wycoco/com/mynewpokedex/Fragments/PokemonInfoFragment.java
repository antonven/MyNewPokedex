package myapps.wycoco.com.mynewpokedex.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import myapps.wycoco.com.mynewpokedex.R;
import myapps.wycoco.com.mynewpokedex.Volley.VolleySingleton;

import static myapps.wycoco.com.mynewpokedex.R.id.progressBar;

/**
 * Created by dell on 7/8/2017.
 */

public class PokemonInfoFragment extends Fragment {

    TextView pokeNo, pokeName, pokeType, pokeWeight, pokeHeight, pokeVersion;
    ImageView pokemonImage;
    int id;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_pokemon_data2, container, false);


        pokeNo = (TextView) v.findViewById(R.id.pokeNo);
        pokeName = (TextView)v. findViewById(R.id.pokeName);
        pokemonImage = (ImageView) v.findViewById(R.id.imageView);
        pokeType = (TextView) v.findViewById(R.id.pokeType);
        pokeWeight = (TextView) v.findViewById(R.id.pokeWeight);
        pokeHeight = (TextView)v. findViewById(R.id.pokeHeight);
        pokeVersion = (TextView)v. findViewById(R.id.pokeVersion);




        if(getArguments() != null){
            String image = getArguments().getString("pokeImage");
            String name = getArguments().getString("pokeName");
            id = getArguments().getInt("pokeNo");

            Glide.with(getContext()).load(image).centerCrop().crossFade().into(pokemonImage);
            pokeName.setText(name);
        }
//        Toast.makeText(getContext(), "" + id, Toast.LENGTH_SHORT).show();
        JsonRequest();

        return v;
    }

    private void JsonRequest(){
        JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(Request.Method.GET, "http://pokeapi.co/api/v2/pokemon/" + id + "/",
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if(response != null) {

                            try {
                                JSONArray jsonArray1 = response.getJSONArray("types");
                                Log.e("ANTON VEN", "naabot diri2");

                                for (int o = 0; o < jsonArray1.length(); o++) {
                                    JSONObject pokemonmon = jsonArray1.getJSONObject(o);

                                    JSONObject jsonObject4 = pokemonmon.getJSONObject("type");
                                    pokeType.append(jsonObject4.getString("name").toUpperCase());
//                                    if(jsonObject4.getString("name").equals("fire")){
//
//                                    }

                                }
                            }catch (JSONException e){
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        VolleySingleton.getInstance().addToRequestQueue(jsonObjectRequest1);

        jsonObjectRequest1.setRetryPolicy(new DefaultRetryPolicy(
                5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));
    }
}
