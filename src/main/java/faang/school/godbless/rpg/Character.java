package faang.school.godbless.rpg;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Character {
    private final String name;
    private List<Item> inventory;
}
