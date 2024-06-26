package faang.school.godbless.StarWars;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Robot {
    private String name;
    private int attackPower;
    private int defensePower;
    @Setter
    private int hp;
}
