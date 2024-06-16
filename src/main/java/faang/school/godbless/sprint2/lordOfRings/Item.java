package faang.school.godbless.sprint2.lordOfRings;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {

    private String name;
    private Integer value;

    public static boolean isValidItem(Item item) {
        return item != null;
    }
}
