package school.faang.rpg.lord_of_the_rings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Character {
    private final String name;
    private List<Item> inventory;
}
