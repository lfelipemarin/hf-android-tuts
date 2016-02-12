package com.example.felipe.starbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TopLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        //The item click listener
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            // override this method to perform an action when the item has been clicked
            // the parameter parent is the ListView, view is the view that was clicked, position
            // is the position of the view that was clicked and the id, in case of an array, is
            // the index, in case of a database is the id of the element.
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(TopLevelActivity.this, DrinkCategoryActivity.class);
                    startActivity(intent);
                }
            }
        };
        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }
}
