package com.resiepe.taleeb.logmain;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONObject;

public class user1activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Fragment fragment;
    private FragmentTransaction ft;
    private DrawerLayout drawer;

    TextView ubirthday;
    TextView ulocation;
    TextView uphone;
    TextView ueducation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user1activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        ubirthday=(TextView)findViewById(R.id.ubirthday);
        uphone=(TextView)findViewById(R.id.uphone);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);


        JSONObject userreceipe = new JSONObject();
        try {
         /*   userreceipe.put("firstname", "sahar");
            userreceipe.put("username", "sahar123");
            userreceipe.put("password", "1234");
            userreceipe.put("passwordagain", "1234");
            userreceipe.put("email", "sahar@example.com");


            JSONArray resepeslist= new JSONArray();
            JSONObject userreciepe=new JSONObject();

             userreciepe.put("title","maqlouba");
             userreciepe.put("description","firstreciepe");
             resepeslist.put(userreciepe);

            JSONObject userreciepe2=new JSONObject();

            userreciepe2.put("title","mosakhan");
            userreciepe2.put("description","secondreciepe");
            resepeslist.put(userreciepe2);
*/

            //read json file
            //  String title =fileJison.getString("name");
            //String description =fileJison.getString("desc");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user1activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.notification) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
      private void DisplayFragment(int id){
           Fragment fragment = null;

          switch (id){
              case R.id.profile:
                  fragment = new com.resiepe.taleeb.logmain.userprofilefragment();
                  break;

              case R.id.addfriend:
                  fragment = new com.resiepe.taleeb.logmain.addfriendfragment();
                  break;

              case R.id.addrecipe:
                  fragment = new com.resiepe.taleeb.logmain.addreciepefragment();
                  break;

          }
          if(fragment!=null){

             android.support.v4.app.FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
              ft.replace(R.id.Profilelayout,fragment);
              ft.commit();

          }

          DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
          drawer.closeDrawer(GravityCompat.START);
      }*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        drawer.closeDrawers();

        ft = getFragmentManager().beginTransaction();
        Log.e(" id"," " + item.getItemId());
        if (id == R.id.profile) {

            fragment = userprofilefragment.newInstance();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
            return true;
            // Handle the camera action
        } else if (id == R.id.friends) {
            fragment = friendsfragment.newInstance();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
            return true;
        } else if (id == R.id.myreseipes) {
            fragment = reciepefragment.newInstance();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
            return true;
        } else if (id == R.id.addfriend) {
            fragment = addfriendfragment.newInstance();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
            return true;
        } else if (id == R.id.addrecipe) {
            fragment = addreciepefragment.newInstance();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
            return true;
        }else if (id == R.id.group) {
            fragment = groupfragment.newInstance();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
            return true;
        }else if (id == R.id.logout) {
            finish();

        }
        //      DisplayFragment(R.id.profile);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
