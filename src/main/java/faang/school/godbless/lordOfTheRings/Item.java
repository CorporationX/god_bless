package faang.school.godbless.lordOfTheRings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Item {
    private final String name;
    private int value;
}
