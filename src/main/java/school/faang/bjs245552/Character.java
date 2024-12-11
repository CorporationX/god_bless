package school.faang.bjs245552;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Character {
    private final String id;
    private List<Item> inventory;


    public Character(String id) {
        this.id = id;
        this.inventory = new ArrayList<>();
    }

}
