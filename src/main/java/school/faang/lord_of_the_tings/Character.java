package school.faang.lord_of_the_tings;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private final List<Item> inventory;

    public Character() {
        this.inventory = new ArrayList<>();
    }
}
