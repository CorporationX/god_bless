package school.faang.bjs274728;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Quest {

    private String name;
    private int difficulty;
    private int reward;
}