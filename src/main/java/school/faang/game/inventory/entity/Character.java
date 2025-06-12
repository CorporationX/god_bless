package school.faang.game.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Character {
    private String name;
    private final List<Item> inventory;

    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }
}
