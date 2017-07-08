package myapps.wycoco.com.mynewpokedex.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myapps.wycoco.com.mynewpokedex.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BerriesFragment extends Fragment {


    public BerriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_berries, container, false);
    }

}
