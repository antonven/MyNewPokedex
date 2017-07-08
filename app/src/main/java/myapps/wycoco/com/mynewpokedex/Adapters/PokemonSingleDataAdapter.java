package myapps.wycoco.com.mynewpokedex.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import myapps.wycoco.com.mynewpokedex.Models.PokemonDataModel;
import myapps.wycoco.com.mynewpokedex.R;

/**
 * Created by dell on 7/7/2017.
 */

public class PokemonSingleDataAdapter extends RecyclerView.Adapter<PokemonSingleDataAdapter.ViewHolder> {


    Context mContext;
    ArrayList<PokemonDataModel> pokemon;
    RecyclerView recyclerView;

    public PokemonSingleDataAdapter() {
    }

    public PokemonSingleDataAdapter(Context mContext, ArrayList<PokemonDataModel> pokemon) {
        this.mContext = mContext;
        this.pokemon = pokemon;
    }

    @Override
    public PokemonSingleDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_pokemon_data2, parent, false);
        ViewHolder v = new ViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(PokemonSingleDataAdapter.ViewHolder holder, int position) {

        Glide.with(mContext).load(pokemon.get(position).getPokeImage()).into(holder.pokeImage);
        holder.pokeName.setText(pokemon.get(position).getPokeName());
        holder.pokeType.setText(pokemon.get(position).getPokeType());
        holder.pokeWeight.setText(pokemon.get(position).getPokeWeight());
        holder.pokeHeight.setText(pokemon.get(position).getPokeHeight());
        holder.pokeVersion.setText(pokemon.get(position).getPokeVersion());
    }

    @Override
    public int getItemCount() {
        return pokemon.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView item;
        TextView pokeNo, pokeName, pokeType, pokeWeight, pokeHeight, pokeVersion;
        ImageView pokeImage;

        public ViewHolder(final View itemView) {
            super(itemView);

            pokeNo = (TextView)itemView.findViewById(R.id.pokeNo);
            pokeName = (TextView)itemView.findViewById(R.id.pokeName);
            pokeImage = (ImageView)itemView.findViewById(R.id.pokeImage);
            pokeType = (TextView)itemView.findViewById(R.id.pokeType);
            pokeWeight = (TextView)itemView.findViewById(R.id.pokeWeight);
            pokeHeight = (TextView)itemView.findViewById(R.id.pokeHeight);
            pokeVersion = (TextView)itemView.findViewById(R.id.pokeVersion);

        }
    }
}
