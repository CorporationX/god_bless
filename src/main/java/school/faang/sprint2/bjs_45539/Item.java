package school.faang.sprint2.bjs_45539;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Item {
    private final String name;
    @Setter
    private int itemCost;
}
