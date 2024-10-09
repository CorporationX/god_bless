package school.faang.Lambda.BJS2_33646;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Character {
    @Getter
    private final List<Item> inventory;
    private String name;

    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

}
