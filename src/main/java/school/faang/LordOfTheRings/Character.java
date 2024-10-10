package school.faang.LordOfTheRings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private final List<Item> inventory;
    private String name;

    public Character(String name) {
        this.name = name;
        inventory = new ArrayList<>();
    }
}
