package ru.kraiush.threads.BJS2_23877;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Room {

    private String name;
    private int number;

    public Room(String name) {
        this.name = name;
    }

    List<Food> listFoods;

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
