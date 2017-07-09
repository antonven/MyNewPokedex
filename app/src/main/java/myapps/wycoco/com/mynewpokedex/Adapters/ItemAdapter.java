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

import myapps.wycoco.com.mynewpokedex.Models.ItemModel;
import myapps.wycoco.com.mynewpokedex.R;

/**
 * Created by dell on 7/8/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    Context mContext;
    ArrayList<ItemModel> items;

    public ItemAdapter(Context mContext, ArrayList<ItemModel> items) {
        this.mContext = mContext;
        this.items = items;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_items, parent, false);
        ViewHolder v = new ViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {
        Glide.with(mContext).load(items.get(position).getImageUrl()).into(holder.itemImage);
        holder.itemName.setText(items.get(position).getItemName());
        holder.itemEffect.setText(items.get(position).getItemEffect());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView itemName, itemEffect;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            itemImage = (ImageView)itemView.findViewById(R.id.pokeballImage);
            itemName = (TextView)itemView.findViewById(R.id.itemName);
            itemEffect = (TextView)itemView.findViewById(R.id.itemEffect);
            cardView = (CardView)itemView.findViewById(R.id.cardView);


        }
    }
}
