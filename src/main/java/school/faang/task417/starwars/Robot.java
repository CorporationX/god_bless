package school.faang.task417.starwars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Robot {
    private String name;
    private int attackPower;
    private int defensePower;
}
