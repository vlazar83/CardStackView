package com.vlazar83.cardstackview;

public class Spot {

    private int id;
    private String name;
    private String city;
    private String url;

    private static int counter = 0;

    public Spot(int id, String name, String city, String url) {
        this.id = id + counter;
        this.name = name;
        this.city = city;
        this.url = url;

        counter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Spot.counter = counter;
    }
}
