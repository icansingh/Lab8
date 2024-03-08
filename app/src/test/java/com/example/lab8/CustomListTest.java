package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomListTest {
    private CustomList list; /**
     * create a mocklist for my citylist * @return
     */

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        list.addCity(mockCity());
        return list;
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
        list = MockCityList();
        City city1 = mockCity();
        City city2 = new City("Charlottetown", "Prince Edward Island");
        assertTrue(list.hasCity(city1), "Edmonton in List");
        assertFalse(list.hasCity(city2), "Charlottetown not in list");
    }

    @Test
    void testDeleteCity() {
        CustomList cityList = MockCityList();
        City city2 = new City("Charlottetown", "Prince Edward Island");

        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            cityList.deleteCity(city2);
        });

        assertEquals("City not found", exception.getMessage());
    }

    @Test
    void testCountCities(){
        CustomList cityList = MockCityList();
        City city2 = new City("Charlottetown", "Prince Edward Island");
        City city3 = new City("Toronto", "Ontario");
        cityList.addCity(city2);
        cityList.addCity(city3);

        assertEquals(3, cityList.countCities());
    }

}
