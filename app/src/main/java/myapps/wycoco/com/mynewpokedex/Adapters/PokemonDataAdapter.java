package myapps.wycoco.com.mynewpokedex.Adapters;

import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import myapps.wycoco.com.mynewpokedex.Fragments.PokemonInfoFragment;
import myapps.wycoco.com.mynewpokedex.Models.PokemonDataModel;
import myapps.wycoco.com.mynewpokedex.R;

/**
 * Created by dell on 7/6/2017.
 */

public class PokemonDataAdapter extends RecyclerView.Adapter<PokemonDataAdapter.ViewHolder> {

    Context mContext;
    ArrayList<PokemonDataModel> pokemon;
    RecyclerView recyclerView;
    off set;

    public PokemonDataAdapter() {
    }

    public PokemonDataAdapter(Context mContext, ArrayList<PokemonDataModel> pokemon) {
        this.mContext = mContext;
        this.pokemon = pokemon;
        this.set = set;
    }

    @Override
    public PokemonDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_data_item, parent, false);
        ViewHolder v = new ViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(PokemonDataAdapter.ViewHolder holder, int position) {

        Glide.with(mContext).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+pokemon.get(position).getNumber()+".png").into(holder.pokeImage);
        holder.pokeName.setText(pokemon.get(position).getPokeName());
        holder.pokeNo.setText(pokemon.get(position).getPokeNo());

    }

    @Override
    public int getItemCount() {
        return pokemon.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView item;
        TextView pokeNo, pokeName;
        ImageView pokeImage;

        public ViewHolder(final View itemView) {
            super(itemView);

            pokeNo = (TextView)itemView.findViewById(R.id.pokeNo);
            pokeName = (TextView)itemView.findViewById(R.id.pokeName);
            pokeImage = (ImageView)itemView.findViewById(R.id.pokeImage);
            item = (CardView)itemView.findViewById(R.id.cardView);


            item.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    String pokeName = pokemon.get(getAdapterPosition()).getPokeName();
                    int pokeID = pokemon.get(getAdapterPosition()).getNumber();
                    String pokeWeight = pokemon.get(getAdapterPosition()).getPokeWeight();
                    String pokeHeight = pokemon.get(getAdapterPosition()).getPokeHeight();
                    String pokeType= pokemon.get(getAdapterPosition()).getPokeType();
                    String pokeVersion = pokemon.get(getAdapterPosition()).getPokeVersion();
                    String pokeImage = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+pokemon.get(getAdapterPosition()).getNumber()+".png";
                    FragmentManager fm = ((AppCompatActivity) mContext).getSupportFragmentManager();

                    PokemonInfoFragment pk = new PokemonInfoFragment();
                    Toast.makeText(mContext, "a" + pokeID, Toast.LENGTH_SHORT).show();
                    Bundle args = new Bundle();
                    args.putString("pokeName", pokeName);
                    args.putInt("pokeNo", pokeID);
                    args.putString("pokeImage", pokeImage);
//                    args.putString("pokeWeight", pokeWeight);
//                    args.putString("pokeHeight", pokeHeight);
//                    args.putString("pokeType", pokeType);
//                    args.putString("pokeVersion", pokeVersion);
                    pk.setArguments(args);

                    fm.beginTransaction().replace(R.id.activityFrame, pk)
                            .addToBackStack("pokeInfo")
                            .commit();


                }
            });
        }
    }
    public interface off{
        public void ioff();
    }
}
