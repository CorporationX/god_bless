package school.faang.bjs2_88455;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Character {
    private final String name;
    private ArrayList<Item> inventory;

    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }
}
