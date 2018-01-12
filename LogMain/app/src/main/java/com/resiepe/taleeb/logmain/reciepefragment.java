package com.resiepe.taleeb.logmain;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.resiepe.taleeb.logmain.userprofilefragment.readTextFile;

/**
 * Created by Taleeb on 1/6/2018.
 */

public class reciepefragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.reciepelayout,container,false);
        String data =   readTextFile(getActivity(),R.raw.mydata);

        try {






                JSONObject jsonObj = new JSONObject(data);

                // Getting JSON Array node
                JSONArray contacts = jsonObj.getJSONArray("recipe");

                // looping through All Contacts
                for (int j = 0; j < contacts.length(); j++) {
                    JSONObject c = contacts.getJSONObject(j);

                    String title = c.getString("title");
                    String description = c.getString("description");
                   // String img = c.getString("img");

                }

   //             title1=(TextView)fiib(R.id.title);

 //               title1.setText(title);

//
//                "recipe": [
//                {
//                    "title": "maqlopa",
//                        "description": "add rise ...",
//                        "id": "25",
//                        "img": "url img"
//                }
//
//            ]
//







        } catch (JSONException e) {
            e.printStackTrace();
        }

        return v;
    }



    public static reciepefragment newInstance() {
        reciepefragment fragment = new reciepefragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
