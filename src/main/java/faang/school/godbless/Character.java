package faang.school.godbless;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    String name;
    List<Item> inventory;

    public Character(String name) {
        this.inventory = new java.util.ArrayList<>();
    }
}
