package school.faang.bjs2_87318;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Character {
    private String name;
    private ArrayList<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

}
