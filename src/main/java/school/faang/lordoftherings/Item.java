package school.faang.lordoftherings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Item {
    private String name;
    private int value;
}
