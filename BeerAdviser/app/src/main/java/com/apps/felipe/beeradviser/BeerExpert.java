package com.apps.felipe.beeradviser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felipe on 2/2/16.
 */
public class BeerExpert {
    public List<String> getBrands(String color) {
        List<String> brands = new ArrayList<>();
        if (color.equals("amber")) {
            brands.add("Jack Amber");
            brands.add("Red Moose");
        } else {
            brands.add("Jail Pale Ale");
            brands.add("Gout Stout");
        }
        return brands;
    }
}
