package school.faang.sprint_2.lord_of_the_rings_rpg;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Character {
    private String name;
    private List<Item> inventory;
}
