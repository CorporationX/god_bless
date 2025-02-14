package school.faang.lordOfTheRings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@NonNull
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
        inventory = new ArrayList<>();
    }
}
