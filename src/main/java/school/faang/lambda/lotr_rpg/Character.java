package school.faang.lambda.lotr_rpg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Character {
    private final String name;
    @Setter
    private List<Item> inventory;
}
