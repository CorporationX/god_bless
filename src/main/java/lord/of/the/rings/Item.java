package lord.of.the.rings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Item {
    private String name;
    private int value;
}
