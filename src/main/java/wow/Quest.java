package wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Quest {
    private String name;
    private int difficult;
    private int reward;
}
