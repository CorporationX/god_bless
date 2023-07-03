package main.java.faang.school.godbless.rpg;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class Character {
    List<Item> inventory;

    public Character() {
        inventory = new ArrayList<>();
    }
}
