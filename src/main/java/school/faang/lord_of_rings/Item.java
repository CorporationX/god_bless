package school.faang.lord_of_rings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Item {
    private String name;
    @Setter
    private int value;
}
