package com.resiepe.taleeb.logmain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PageGuest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final   ArrayList<ListResipe> Items=new ArrayList<ListResipe>();
        Items.add(new ListResipe("maqlouba","the first recipe "));
        Items.add(new ListResipe("mansaf","second recipe >>>>"));
        Items.add(new ListResipe("mosakhan","thirsd recipeeeee"));
        Items.add(new ListResipe("mjaddra","other recipeee "));
        final MyCustomAdapter myadpter= new MyCustomAdapter(Items);

        ListView ls=(ListView)findViewById(R.id.listView);
        ls.setAdapter(myadpter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView recipename =(TextView) view.findViewById(R.id.txt_name);
                TextView recipedes =(TextView) view.findViewById(R.id.txt_desc);
                Toast.makeText(getApplicationContext(),recipename.getText(), Toast.LENGTH_LONG).show();
                Items.add(new ListResipe("maqlouba with meat", "deffrence other maqlouba "));
                Items.add(new ListResipe("other recipe", "tessssts "));
                myadpter.notifyDataSetChanged();

            }
        });

    }


    class MyCustomAdapter extends BaseAdapter
    {
        ArrayList<ListResipe> Items=new ArrayList<ListResipe>();
        MyCustomAdapter(ArrayList<ListResipe> Items ) {
            this.Items=Items;

        }


        @Override
        public int getCount() {
            return Items.size();
        }

        @Override
        public String getItem(int position) {
            return Items.get(position).ResipeTitle;

        }

        @Override
        public long getItemId(int position) {
            return  position;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater linflater =getLayoutInflater();
            View view1=linflater.inflate(R.layout.row_view, null);

            TextView txtname =(TextView) view1.findViewById(R.id.txt_name);
            TextView txtdes =(TextView) view1.findViewById(R.id.txt_desc);
            txtname.setText(Items.get(i).ResipeTitle);
            txtdes.setText(Items.get(i).RecipeDesc);
            return view1;

        }



    }
}
