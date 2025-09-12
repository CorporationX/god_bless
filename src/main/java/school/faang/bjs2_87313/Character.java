package school.faang.bjs2_87313;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class Character {
    private final String name;
    @Setter
    private List<Item> inventory;

    public Character(String name) {
        this.inventory = new ArrayList<>();
        this.name = name;
    }
}
