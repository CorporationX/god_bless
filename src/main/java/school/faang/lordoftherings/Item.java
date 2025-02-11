package school.faang.lordoftherings;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private String name;
    private int value;
    private Rareness rareness;
}
