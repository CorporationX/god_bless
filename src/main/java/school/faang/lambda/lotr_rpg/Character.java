package school.faang.lambda.lotr_rpg;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Character {
    private final String name;
    private final List<Item> inventory;
}
