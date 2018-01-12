package com.resiepe.taleeb.logmain;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.resiepe.taleeb.logmain.R;

/**
 * Created by Taleeb on 1/5/2018.
 */

public class addfriendfragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

           View v= inflater.inflate(R.layout.addedfriend,container,false);

       return v;

    }
    public static addfriendfragment newInstance() {
        addfriendfragment fragment = new addfriendfragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
