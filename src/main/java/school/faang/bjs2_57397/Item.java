package school.faang.bjs2_57397;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Item {
    private final String name;
    @Setter
    private int value;
}
