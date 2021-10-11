package com.example.learnactivity3;

import java.util.ArrayList;
import java.util.List;

public class City {

    String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static List<City> getList(){
        List<City> cityList = new ArrayList<>();
        String name[] = {
                "深圳","广州","惠州","东莞","肇庆","韶关","阳江","汕头","揭阳","潮州","江门","汕尾"
        };
        City city[] = new City[name.length];

        for (int i = 0; i < name.length; i++){
            city[i] = new City(name[i]);
            cityList.add(city[i]);
        }
        return cityList;
    }
}
