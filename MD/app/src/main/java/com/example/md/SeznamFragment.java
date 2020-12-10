package com.example.md;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

public class SeznamFragment extends ListFragment {

    int mVybrany = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String> connectArrayToListView = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_activated_1,AndroidInfo.NAZVY);

        //Připoj ListView na data
        setListAdapter(connectArrayToListView);
        View detailsFrame = getActivity().findViewById(R.id.proObaFragmenty);

        // onSaveInstanceState() při rotaci
        if (savedInstanceState != null) {
            // obnov pozici
            mVybrany = savedInstanceState.getInt("curChoice", 0);
        }

    }

    // změna orientace
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", mVybrany);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        showDetails(position);
    }

    public void showDetails(int index){
        mVybrany = index;

        Configuration configInfo = getResources().getConfiguration();
        if (configInfo.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            getListView().setItemChecked(index, true);

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            DetailFragment details;



            details = (DetailFragment)getFragmentManager().findFragmentById(R.id.Dvafragment);

            if (details == null || details.getShownIndex() != index) {
                details = DetailFragment.newInstance(index);
                ft.replace(R.id.Dvafragment, details);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        }
        else {
            Intent intent = new Intent();
            intent.setClass(getActivity(), DetailsActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);

        }
    }
}
