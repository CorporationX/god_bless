package school.faang.bjs2_33879.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Character {
    private List<Item> inventory;
    private String name;

    public Character(String name) {
        this.name = name;
    }
}
