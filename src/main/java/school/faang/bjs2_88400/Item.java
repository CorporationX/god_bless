package school.faang.bjs2_88400;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Item {
    private String name;
    private int value;
    @Setter private int amount;
}
