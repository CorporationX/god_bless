package school.faangSprint2.t5;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

class Character {
    private String name;
    @Getter
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }
}