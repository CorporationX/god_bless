package school.faang_sprint_2.lord_of_the_rings_rpg;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private final String name;
    private int price;
}
