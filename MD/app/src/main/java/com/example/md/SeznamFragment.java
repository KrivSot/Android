package com.example.md;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

public class SeznamFragment extends ListFragment {

    boolean mDvaPanely;

    int mVybrany = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String> connectArrayToListView = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_activated_1,AndroidInfo.NAZVY);

        setListAdapter(connectArrayToListView);
        View detailsFrame = getActivity().findViewById(R.id.detaily);
        mDvaPanely = detailsFrame !=null && detailsFrame.getVisibility() == View.VISIBLE;
        if (savedInstanceState != null){
            mVybrany = savedInstanceState.getInt("curChoice",0);
        }

        if(mDvaPanely){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(mVybrany);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice",mVybrany);
    }

    @Override
    public void onListItemClick(ListView l,View v, int position, long id){
        showDetails(position);
    }

    void showDetails(int index){
        mVybrany = index;
            if(mDvaPanely){
                getListView().setItemChecked(index,true);
                DetailFragment details = (DetailFragment) getFragmentManager().findFragmentById(R.id.detaily);



            if(details ==null || details.getShownIndex() != index){
                details = DetailFragment.newInstance(index);
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.detaily,details);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            } else{
                Intent intent = new Intent();
                intent.setClass(getActivity(),DetailsActivity.class);
                intent.putExtra("index",index);
                startActivity(intent);
            }
        }
    }
}
