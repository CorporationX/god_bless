package school.faang.lord_of_the_rings;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private String name;
    private Long value;
}