package school.faang.lord_of_the_rings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Item {
    private String name;
    private int value;
}
