package com.example.lab8;

public class City implements Comparable{

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * This method compares the two city objects based on the city name
     * @param o the object to be compared.
     * @return an integer specifying the comparison between cities
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city_object = (City) o;
        return city.equals(city_object.city) &&
                province.equals(city_object.province);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(city, province);
    }
}
