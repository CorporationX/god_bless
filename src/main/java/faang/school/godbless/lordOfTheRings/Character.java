package faang.school.godbless.lordOfTheRings;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Character {
    private String name;
    private List<Item> inventory;
}
