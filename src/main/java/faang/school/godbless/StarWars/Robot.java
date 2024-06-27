package faang.school.godbless.StarWars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Data
public class Robot {
    private String name;
    private int attackPower;
    private int defensePower;

}
