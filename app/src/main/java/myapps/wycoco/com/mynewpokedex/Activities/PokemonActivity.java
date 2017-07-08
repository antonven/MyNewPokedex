//package myapps.wycoco.com.mynewpokedex.Activities;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.Volley;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//
//import myapps.wycoco.com.mynewpokedex.Adapters.PokemonDataAdapter;
//import myapps.wycoco.com.mynewpokedex.Models.PokemonDataModel;
//import myapps.wycoco.com.mynewpokedex.R;
//import myapps.wycoco.com.mynewpokedex.Volley.VolleySingleton;
//
//public class PokemonActivity extends AppCompatActivity {
//
//    private String url = "http://pokeapi.co/api/v2/pokemon";
//    private static String TAG = PokedexActivity.class.getSimpleName();
//
//    TextView pokeNo, pokeName, pokeType, pokeWeight, pokeHeight, pokeVersion;
//    ImageView pokeImage;
//
//    RecyclerView recView2;
//
//    PokemonDataAdapter pokemonDataAdapter;
//    RequestQueue requestQueue;
//    ProgressBar progressBar;
//    boolean b = true;
//    int offset = 0, no;
//    ArrayList<PokemonDataModel> pokemonsters = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pokemon_data2);
//
//        pokeNo = (TextView) findViewById(R.id.pokeNo);
//        pokeName = (TextView) findViewById(R.id.pokeName);
//        pokeImage = (ImageView) findViewById(R.id.pokeImage);
//        pokeType = (TextView) findViewById(R.id.pokeType);
//        pokeWeight = (TextView) findViewById(R.id.pokeWeight);
//        pokeHeight = (TextView) findViewById(R.id.pokeHeight);
//        pokeVersion = (TextView) findViewById(R.id.pokeVersion);
//
//
//        requestQueue = Volley.newRequestQueue(this);
//        recView2 = (RecyclerView) findViewById(R.id.recView2);
//        progressBar = (ProgressBar) findViewById(R.id.progressBar);
//        Intent intent = getIntent();
//        Bundle args = getIntent().getExtras();
//        String name = args.getString("pokeName");
//        no = args.getInt("pokeNo");
////        String image = args.getString("pokeImage");
////        String weight = args.getString("pokeWeight");
////        String height = args.getString("pokeHeight");
////        String type = args.getString("pokeType");
////        String ver = args.getString("pokeVersion");
//
////        String id = intent.getStringExtra("pokeID");
////        int pokeID = intent.getIntExtra("pokeID", 0);
//
//
////        Glide.with(this).load(image).into(pokeImage);
//          pokeName.setText(name);
////        pokeNo.setText(no + "");
////        pokeType.setText(type);
////        pokeWeight.setText(weight + " kg");
////        pokeHeight.setText(height + " cm");
////        pokeVersion.setText(image);
//
//    }
//
//    private void request(){
//        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.GET, "http://pokeapi.co/api/v2/pokemon/" + no+ "/",
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try{
//                            if(response != null) {
//                                progressBar.setVisibility(View.GONE);
//
//                                JSONArray jsonArray1 = response.getJSONArray("types");
//
//                                Log.e("Kirsten", "naabot diri2");
//
//                                for (int o = 0; o < jsonArray1.length(); o++) {
//                                    JSONObject pokemonmon = jsonArray1.getJSONObject(o);
//
//                                    JSONObject jsonObject4 = pokemonmon.getJSONObject("type");
////                                    String pokeType = jsonObject4.getString("name").toUpperCase();
//                                    pokeType.setText(jsonObject4.getString("name").toUpperCase());
//                                }
//
//
//                            }
//                        }catch (JSONException e){
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
////                                                Toast.makeText(getContext(), "There is no connection!", Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );
//        Log.e("Kirsten", "naabot diri");
//
//
//        VolleySingleton.getInstance().addToRequestQueue(jsonObjectRequest2);
//    }
//}
