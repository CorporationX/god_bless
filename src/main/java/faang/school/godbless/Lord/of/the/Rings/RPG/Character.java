package faang.school.godbless.Lord.of.the.Rings.RPG;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Character {
    private List<Item> inventory;
    private String name;

    public Character(String name) {
        this.name = name;
    }
}
