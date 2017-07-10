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

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import myapps.wycoco.com.mynewpokedex.Adapters.ItemAdapter;
import myapps.wycoco.com.mynewpokedex.Adapters.PokemonDataAdapter;
import myapps.wycoco.com.mynewpokedex.Models.ItemModel;
import myapps.wycoco.com.mynewpokedex.Models.PokemonDataModel;
import myapps.wycoco.com.mynewpokedex.R;
import myapps.wycoco.com.mynewpokedex.Volley.VolleySingleton;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsFragment extends Fragment {

    RecyclerView recView;
    ArrayList<ItemModel> items = new ArrayList<>();
    ItemAdapter itemAdapter;
    boolean boy;
    int offset = 0;
    String itemUrl, itemName, itemImageUrl;
    ProgressBar progressBar ;
    int itemNo;

    public ItemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pokemon_data, container,false);

        recView = (RecyclerView) v.findViewById(R.id.recView);
        progressBar = (ProgressBar)v.findViewById(R.id.progressBar);



        JsonRequest(v);

        boy = true;

        return v;
    }


    public void JsonRequest(final View view){

        JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(Request.Method.GET, "http://pokeapi.co/api/v2/item/?offset=" + offset + "/",
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if(response != null)
                        progressBar.setVisibility(View.GONE);
                        Log.e("HELLO", "huwat lang");
                        try {
                            JSONArray jsonArray1 = response.getJSONArray("results");
                            Log.e("asda", "naabot driir" + jsonArray1);
                            for(int p = 0; p < jsonArray1.length(); p++) {
                                JSONObject jsonObject1 = jsonArray1.getJSONObject(p);
                                itemUrl = jsonObject1.getString("url");
                                itemName = jsonObject1.getString("name");
                                String[] urlCuts = itemUrl.split("/");
                                itemNo = Integer.parseInt(urlCuts[urlCuts.length - 1]);
                                itemImageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/" + itemName + ".png";
                                Log.e("shet", "naabot nasd diri");
                                final ItemModel itemModel = new ItemModel();
                                itemModel.setItemName(itemName);
                                itemModel.setItemNumber(itemNo);
                                itemModel.setImageUrl(itemImageUrl);

                                JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.GET, "http://pokeapi.co/api/v2/item/" + itemNo + "/",
                                        new Response.Listener<JSONObject>() {
                                            @Override
                                            public void onResponse(JSONObject response) {
                                                try {
                                                    JSONArray jsonArray = response.getJSONArray("effect_entries");
                                                    for (int o = 0; o <= jsonArray.length(); o++) {
                                                        JSONObject jsonObject = jsonArray.getJSONObject(o);
                                                        String itemEff = jsonObject.getString("effect");
                                                        itemModel.setItemEffect(itemEff);
                                                        Log.e("asdasdas", "naabot sad diri tawn" + itemEff);

                                                    }
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        },
                                        new Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {

                                            }
                                        });

                                VolleySingleton.getInstance().addToRequestQueue(jsonObjectRequest2);
                                items.add(itemModel);
                                itemAdapter = new ItemAdapter(getContext(), items);
                                final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                                recView.setLayoutManager(layoutManager);
                                recView.setItemAnimator(new DefaultItemAnimator());
                                recView.setAdapter(itemAdapter);

                                recView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                                    @Override
                                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                                        super.onScrolled(recyclerView, dx, dy);
                                        if(dy > 0){
                                            int visibleCount = layoutManager.getChildCount();
                                            final int totalItemCount = layoutManager.getItemCount();
                                            int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                                            if (visibleCount + pastVisibleItems >= totalItemCount) {
                                                boy = false;
                                                offset += 20;

//                                                JsonRequest(view);
                                                boy = true;
//                        Toast.makeText(getContext(), "Last", Toast.LENGTH_SHORT).show();

                                            }
                                        }
                                    }
                                });
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        VolleySingleton.getInstance().addToRequestQueue(jsonObjectRequest1);

    }

//    private void loadMore(final View view, final int set){
//
//        itemAdapter = new ItemAdapter(getContext(), items);
//        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        recView.setLayoutManager(layoutManager);
//        recView.setItemAnimator(new DefaultItemAnimator());
//        recView.setAdapter(itemAdapter);
//
//        recView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                if(dy > 0){
//                    int visibleCount = layoutManager.getChildCount();
//                    final int totalItemCount = layoutManager.getItemCount();
//                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();
//
//                    if (visibleCount + pastVisibleItems >= totalItemCount) {
//                        boy = false;
//                        int offset = set;
//                        offset += 20;
//
//                        JsonRequest(view, offset);
//                        boy = true;
////                        Toast.makeText(getContext(), "Last", Toast.LENGTH_SHORT).show();
//
//                    }
//                }
//            }
//        });
//    }

}
