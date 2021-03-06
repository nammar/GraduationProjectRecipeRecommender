package com.resiepe.taleeb.logmain;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

public class PageGuest extends AppCompatActivity {
    TextToSpeech convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_guest);

        //text to voice
        convert = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status != TextToSpeech.ERROR) {
                    convert.setLanguage(Locale.UK);
                }

            }
        });

        JSONObject fileJison = new JSONObject();
        try {
            fileJison.put("name", "maqlouba");
            fileJison.put("desc", "the first recipe ");
            fileJison.put("name", "mansaf");
            fileJison.put("desc", "second recipe >>>>");
            fileJison.put("name", "maqlouba");
            fileJison.put("desc", "******");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final ArrayList<ListResipe> Items = new ArrayList<ListResipe>();
        Items.add(new ListResipe("maqlouba", "the first recipe "));
        Items.add(new ListResipe("mansaf", "second recipe >>>>"));
        Items.add(new ListResipe("mosakhan", "thirsd recipeeeee"));
        Items.add(new ListResipe("mjaddra", "other recipeee "));
        final MyCustomAdapter myadpter = new MyCustomAdapter(Items);

        ListView ls = (ListView) findViewById(R.id.listView);
        ls.setAdapter(myadpter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView recipename = view.findViewById(R.id.recipe_title);
                TextView recipedes = view.findViewById(R.id.recipe_disc);
                Toast.makeText(getApplicationContext(), recipename.getText(), Toast.LENGTH_LONG).show();
                Items.add(new ListResipe("maqlouba with meat", "deffrence other maqlouba "));
                Items.add(new ListResipe("other recipe", "tessssts "));
                myadpter.notifyDataSetChanged();

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void speak_my_text(String desc) {
        convert.speak(desc, TextToSpeech.QUEUE_FLUSH, null, null);
    }

    class MyCustomAdapter extends BaseAdapter {
        ArrayList<ListResipe> Items = new ArrayList<ListResipe>();

        MyCustomAdapter(ArrayList<ListResipe> Items) {
            this.Items = Items;

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
            return position;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater linflater = getLayoutInflater();
            View view1 = linflater.inflate(R.layout.row_view, null);
            TextView txtname = (TextView) view1.findViewById(R.id.recipe_title);
           final  TextView txtdes = (TextView) view1.findViewById(R.id.recipe_disc);
            Button playclick = (Button) view1.findViewById(R.id.play);
            txtname.setText(Items.get(i).ResipeTitle);
            txtdes.setText(Items.get(i).RecipeDesc);

            playclick.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View view) {
                    speak_my_text(txtdes.getText().toString());

                }
            });
            return view1;

        }


    }


}
