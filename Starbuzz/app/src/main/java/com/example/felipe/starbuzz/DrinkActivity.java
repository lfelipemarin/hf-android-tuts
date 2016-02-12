package com.example.felipe.starbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKNO = "drinkNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        // get the intent and the extras containing the drink id. Also get the drink
        // from the datasource using the drinkNo
        Intent intent = getIntent();
        int drinkNo = (Integer) intent.getExtras().get(EXTRA_DRINKNO);
        Drink drink = Drink.drinks[drinkNo];

        // get the image view and set the contents to it
        ImageView photo = (ImageView) findViewById(R.id.photo);
        // the content description is used for accessibility, impaired users
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());

        // populate the text view for the name
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(drink.getName());

        // populate the text view for the description
        TextView description = (TextView) findViewById(R.id.name);
        description.setText(drink.getDescription());
    }
}
