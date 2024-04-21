package faang.school.godbless.lordOfTheRings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class Item {
    private String name;
    private int value;
}
