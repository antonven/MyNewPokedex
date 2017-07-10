//package myapps.wycoco.com.mynewpokedex.Fragments;
//
//
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//
//import com.android.volley.Request;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.Volley;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import myapps.wycoco.com.mynewpokedex.R;
//import myapps.wycoco.com.mynewpokedex.Volley.VolleySingleton;
//
///**
// * A simple {@link Fragment} subclass.
// */
//public class MovesFragment extends Fragment {
//
//
//    ProgressBar bar;
//    RecyclerView recView3;
//    int offset = 0;
//    public MovesFragment() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        View v = inflater.inflate(R.layout.fragment_pokemon_data, container, false);
//
//        bar = (ProgressBar)v.findViewById(R.id.progressBar);
//        recView3 = (RecyclerView) v.findViewById(R.id.recView);
//
//
//
//        return v;
//    }
//
//    private void JsonRequest(){
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "http://pokeapi.co/api/v2/pokemon/" + offset + "/",
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//
//                        try {
//                            JSONArray jsonArray = response.getJSONArray("results");
//
//                            for(int i = 0; i < jsonArray.length(); i++){
//                                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                                String
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                });
//        VolleySingleton.getInstance().addToRequestQueue(jsonObjectRequest);
//
//
//    }
//
//}
