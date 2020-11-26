package com.example.md;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

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

    }
}
