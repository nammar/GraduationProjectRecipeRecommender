package com.resiepe.taleeb.logmain;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Taleeb on 1/10/2018
 */

public class groupfragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.group_fragment, container, false);
        String data = readTextFile(getActivity(), R.raw.mydata);
        TextView ugroup = (TextView) v.findViewById(R.id.ugroup);

        TextView vvgroup =(TextView) v.findViewById(R.id.ugroup);


// display group that json file saved
        try {
            JSONArray jsonA = new JSONArray(data);
            JSONObject obj = new JSONObject(data);
            JSONArray jsonArray = obj.getJSONArray("user");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String name = object.getString("user");
                if (!name.equals("aya"))
                    continue;

                String gr = object.getString("groups");
                vvgroup.setText(gr);

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


    public static groupfragment newInstance() {
        groupfragment fragment = new groupfragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
/*
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {//display list view/
        super.onViewCreated(view, savedInstanceState);
        final ArrayList<groupListItem> Items=new  ArrayList<groupListItem> ();
        Items.add(new groupListItem("Group1"));
        Items.add(new groupListItem("Group2"));
        Items.add(new groupListItem("Group3"));
        Items.add(new groupListItem("Group4"));
        final MyCustomAdapter myadpter= new MyCustomAdapter(Items);

        groupListItem ls=(groupListItem)findViewById(R.id.listView);
        ls.setAdapter(myadpter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtname =(TextView) view.findViewById(R.id.groupname);

                Toast.makeText(getApplicationContext(),txtname.getText(),Toast.LENGTH_LONG).show();
                Items.add(new groupListItem("group4"));
                Items.add(new groupListItem("group5"));
                myadpter.notifyDataSetChanged();

            }
        });

    }
*/


  /*  class MyCustomAdapter extends BaseAdapter {
        ArrayList<groupListItem> Items = new ArrayList<groupListItem>();

        MyCustomAdapter(ArrayList<groupListItem> Items) {
            this.Items = Items;

        }


        @Override
        public int getCount() {
            return Items.size();
        }

        @Override
        public String getItem(int position) {
            return Items.get(position).groupname;

        }

        @Override
        public long getItemId(int position) {
            return position;
        }

  *//*      @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater linflater =getLayoutInflater();
            View view1=linflater.inflate(R.layout.raw2_view, null);

            TextView txtgroupname =(TextView) view1.findViewById(R.id.groupname);
            txtgroupname.setText(Items.get(i).groupname);
            return view1;

        }*//*


    }*/
    }
}
