package ru.kraiush.lambda.BJS2_21400;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class Character {

    private String name;
    private List<Item> inventory= new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name= " + name + '}';
    }
}