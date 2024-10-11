package lord.of.the.rings.rpg;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Character {
    private String name;
    private List<Item> inventory;
}
