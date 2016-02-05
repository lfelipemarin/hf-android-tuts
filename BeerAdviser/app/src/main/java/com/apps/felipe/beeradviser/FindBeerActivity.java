package com.apps.felipe.beeradviser;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FindBeerActivity extends Activity {

    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);

    }

    //Called when the user clicks the button
    public void onClickFindBeer(View view) {
        //Get a reference to the TextView
        TextView brands = (TextView) findViewById(R.id.brands);
        //Get a reference to the Spinner
        Spinner color = (Spinner) findViewById(R.id.color);
        //Get the selected value from Spinner casted to String
        String beerType = String.valueOf(color.getSelectedItem());
        //Get the alike brands according to the beerType selected
        List<String> brandsList = expert.getBrands(beerType);
        //Create a StringBuilder which is gonna format the final string with the beer brands
        StringBuilder brandsFormatted = new StringBuilder();
        //Go through all the brands and append them to the StringBuilder
        for (String brand : brandsList) {
            brandsFormatted.append(brand).append("\n");
        }
        //Set the formatted brands value to the TextView and display it
        brands.setText(brandsFormatted);
    }

}
