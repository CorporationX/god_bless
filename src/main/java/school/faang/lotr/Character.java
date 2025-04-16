package school.faang.lotr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Character {
    private final String name;
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
    }

}
