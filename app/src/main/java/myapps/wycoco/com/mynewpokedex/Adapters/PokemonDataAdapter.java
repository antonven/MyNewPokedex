package myapps.wycoco.com.mynewpokedex.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import myapps.wycoco.com.mynewpokedex.Activities.PokemonActivity;
import myapps.wycoco.com.mynewpokedex.Models.PokemonDataModel;
import myapps.wycoco.com.mynewpokedex.R;

/**
 * Created by dell on 7/6/2017.
 */

public class PokemonDataAdapter extends RecyclerView.Adapter<PokemonDataAdapter.ViewHolder> {

    Context mContext;
    ArrayList<PokemonDataModel> pokemon;
    RecyclerView recyclerView;

    public PokemonDataAdapter() {
    }

    public PokemonDataAdapter(Context mContext, ArrayList<PokemonDataModel> pokemon) {
        this.mContext = mContext;
        this.pokemon = pokemon;
    }

    @Override
    public PokemonDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_data_item, parent, false);
        ViewHolder v = new ViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(PokemonDataAdapter.ViewHolder holder, int position) {

        Glide.with(mContext).load(pokemon.get(position).getPokeImage()).into(holder.pokeImage);
        holder.pokeName.setText(pokemon.get(position).getPokeName());
//        holder.pokeNo.setText(pokemon.get(position).getPokeNo());

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
                    String pokeID = pokemon.get(getAdapterPosition()).getPokeNo();
                    String pokeWeight = pokemon.get(getAdapterPosition()).getPokeWeight();
                    String pokeHeight = pokemon.get(getAdapterPosition()).getPokeHeight();
                    String pokeType= pokemon.get(getAdapterPosition()).getPokeType();
                    String pokeVersion = pokemon.get(getAdapterPosition()).getPokeVersion();
                    String pokeImage = pokemon.get(getAdapterPosition()).getPokeImage();

                    PokemonDataModel pm = new PokemonDataModel(pokeID, pokeName, pokeImage, pokeType, pokeWeight, pokeHeight, pokeVersion);
                    pokemon.add(pm);


                    Intent n = new Intent(mContext, PokemonActivity.class);
                    n.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    Bundle args = new Bundle();
                    args.putString("pokeName", pokeName);
                    args.putString("pokeNo", pokeID);
                    args.putString("pokeImage", pokeImage);
                    args.putString("pokeWeight", pokeWeight);
                    args.putString("pokeHeight", pokeHeight);
                    args.putString("pokeType", pokeType);
                    args.putString("pokeVersion", pokeVersion);
                    n.putExtras(args);
                    mContext.startActivity(n);
                }
            });
        }
    }
}
