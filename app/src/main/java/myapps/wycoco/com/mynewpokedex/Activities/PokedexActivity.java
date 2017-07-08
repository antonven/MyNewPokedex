package myapps.wycoco.com.mynewpokedex.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import myapps.wycoco.com.mynewpokedex.Fragments.PokemonDataFragment;
import myapps.wycoco.com.mynewpokedex.R;

public class PokedexActivity extends AppCompatActivity {

    TextView label;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.pokemon){
//            label.setText("Pokemon Data");
            setTitle("Pokemon Data");
            fm = getSupportFragmentManager();
            fm.beginTransaction()
                    .replace(R.id.activityFrame, new PokemonDataFragment())
                    .commit();
        }
        if(id == R.id.berries){
            label.setText("Berries");
        }
        if(id == R.id.items){
            label.setText("My Items");
        }
        return super.onOptionsItemSelected(item);
    }
}
