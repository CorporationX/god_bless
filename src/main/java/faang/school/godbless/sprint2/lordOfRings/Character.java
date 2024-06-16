package faang.school.godbless.sprint2.lordOfRings;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Character {

    private String name;
    private List<Item> inventory;

    public Character() {
        this.inventory = new ArrayList<>();
    }

    public Character(String name) {
        this.inventory = new ArrayList<>();
        this.name = name;
    }

    public static boolean isValidCharacter(Character character) {
        return character != null;
    }
}
