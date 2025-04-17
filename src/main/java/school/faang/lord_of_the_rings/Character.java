package school.faang.lord_of_the_rings;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class Character {
    private String name;  // Имя персонажа
    private List<Item> inventory;  // Список предметов

    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }
}