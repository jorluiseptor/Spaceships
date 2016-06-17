package com.jorgesepulveda.spaceships;

import android.app.SearchableInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = (ListView) findViewById(R.id.spaceShipList);
        arrayList = new ArrayList<>();

        // Adapter: You need three parameters 'the context, id of the layout (it will be where the data is shown),
        // and the array that contains the data
        adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, arrayList);

        // Here, you set the data in your ListView
        list.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random rand = new Random();
                Spaceship spaceship1 = new Spaceship();
                spaceship1.setName("Millenium Falcon " + rand.nextInt(100) );

                Snackbar.make(view, "FAB button clicked. " + spaceship1.getName(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                // this line adds the data of your EditText and puts in your array
                arrayList.add(spaceship1.getName());
                // next thing you have to do is check if your adapter has changed
                adapter.notifyDataSetChanged();
            }
        });
    }

}
