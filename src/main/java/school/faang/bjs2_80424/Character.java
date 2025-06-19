package school.faang.bjs2_80424;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
    }
}
