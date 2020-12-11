package com.example.md;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.*;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

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
        iv.setImageResource(R.drawable.ic_launcher_background);
        ll.addView(iv);
        ll.addView(text);
        scroller.addView(ll);
        text.setText(AndroidInfo.POPISY[getShownIndex()]);
        return scroller;
    }
}
