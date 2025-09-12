package school.faang.lord.of.the.rings.rpg;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Character {
    private String name;
    private List<Item> inventory;
}
