package com.example.a7mad.addisababa_tourguidapp;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titles = getResources().getStringArray(R.array.titles);
        listView = findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, titles);
        listView.setAdapter(adapter);

        drawerLayout = findViewById(R.id.drawer_layout);
        listView.setOnItemClickListener(this);


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        android.support.v4.app.Fragment fragment;
        String title = titles[position];
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        switch (position) {
            case 0:
                fragment = new Landmarks();
                ft.replace(R.id.frame_layout, fragment);
                break;
            case 1:
                fragment = new Restuarants();
                ft.replace(R.id.frame_layout, fragment);
                break;
            case 2:
                fragment = new Festivals();
                ft.replace(R.id.frame_layout, fragment);
                break;
            case 3:
                fragment = new HistoricSites();
                ft.replace(R.id.frame_layout, fragment);
                break;
        }

        ft.addToBackStack(null);
        ft.commit();

        getSupportActionBar().setTitle(title);

        drawerLayout.closeDrawer(listView);
    }

}


