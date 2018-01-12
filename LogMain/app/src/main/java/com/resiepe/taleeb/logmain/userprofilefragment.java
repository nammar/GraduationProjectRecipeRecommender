package com.resiepe.taleeb.logmain;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Taleeb on 1/5/2018.
 */

public class userprofilefragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.userprofile, container, false);
        String data = readTextFile(getActivity(), R.raw.mydata);

        TextView uname = (TextView)v.findViewById(R.id.uname);
        TextView uage = (TextView)v.findViewById(R.id.uage);
        TextView uemail =(TextView)v.findViewById(R.id.uemail);
        TextView ubirthday =(TextView) v.findViewById(R.id.ubirthday);
        TextView ugender = (TextView)v.findViewById(R.id.ugender);
        TextView uphone =(TextView) v.findViewById(R.id.uphone);


        try {
            JSONObject obj = new JSONObject(data);
            JSONArray jsonArray = obj.getJSONArray("user");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String name = object.getString("name");
                if (!name.equals("aya"))
                    continue;


                String gender = object.getString("gender");
                String age = object.getString("age");
                String birthday = object.getString("birthday");
                String phone = object.getString("phone");
                String email = object.getString("email");
                String name1 = object.getString("name");


                uname.setText(name1);
                uage.setText(age);
                ugender.setText(gender);
                uemail.setText(email);
                ubirthday.setText(birthday);
                uphone.setText(phone);


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return v;
    }


    public static String readTextFile(Context ctx, int resId) {
        InputStream inputStream = ctx.getResources().openRawResource(resId);

        InputStreamReader inputreader = new InputStreamReader(inputStream);
        BufferedReader bufferedreader = new BufferedReader(inputreader);
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((line = bufferedreader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
        } catch (IOException e) {
            return null;
        }
        return stringBuilder.toString();
    }
    //read json file


    public static userprofilefragment newInstance() {
        userprofilefragment fragment = new userprofilefragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
