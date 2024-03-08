package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomListTest {
    private CustomList list; /**
     * create a mocklist for my citylist * @return
     */

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>()); return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount(); list.addCity(new City("Estevan", "SK")); assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity() {
        CustomList cityList = MockCityList();
        City city1 = mockCity();
        City city2 = new City("Charlottetown", "Prince Edward Island");
        assertTrue(cityList.hasCity(city1), "Edmonton in List");
        assertFalse(cityList.hasCity(city2), "Charlottetown not in list");
    }

}
