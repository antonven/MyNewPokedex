package myapps.wycoco.com.mynewpokedex.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import myapps.wycoco.com.mynewpokedex.R;

/**
 * Created by dell on 7/11/2017.
 */

public class MovesAdapter extends RecyclerView.Adapter<MovesAdapter.ViewHolder>{

    Context mContext;
    ArrayList<String> arrayList = new ArrayList<>();


    public MovesAdapter(Context mContext, ArrayList<String> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }


    @Override
    public MovesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.moves_item, parent, false);
        ViewHolder v = new ViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(MovesAdapter.ViewHolder holder, int position) {
        holder.move.setText(arrayList.get(position).toUpperCase());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView move;

        public ViewHolder(View itemView) {
            super(itemView);

            move = (TextView)itemView.findViewById(R.id.moveView);
        }
    }
}
