package com.example.md;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.*;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DetailFragment extends Fragment {

    public static DetailFragment newInstance(int index) {
        DetailFragment f = new DetailFragment();

        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ScrollView scroller = new ScrollView(getActivity());
        LinearLayout ll = new LinearLayout(getActivity());
        ll.setOrientation(LinearLayout.VERTICAL);
        ImageView iv = new ImageView(getActivity());
        TextView text = new TextView(getActivity());
        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getActivity().getResources().getDisplayMetrics());
        text.setPadding(padding, padding, padding, padding);
        iv.setPadding(padding,padding,padding,padding);

        //nacte obrazky z xml
        TypedArray imgs = getResources().obtainTypedArray(R.array.kralove);
        iv.setImageResource(imgs.getResourceId(getShownIndex(),0));
        ll.addView(iv);
        ll.addView(text);
        scroller.addView(ll);
        imgs.recycle(); // recycle the array
        ArrayList<kralove> connectArrayToListView;
        List<kralove> kralove = null;
        try {
            XMLPullParserHandler parser = new XMLPullParserHandler();
            kralove = parser.parse(getContext().getAssets().open("data.xml"),false);
            connectArrayToListView = new ArrayList<kralove>(kralove);
            text.setText(String.valueOf(connectArrayToListView.get(getShownIndex())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return scroller;
    }
}
