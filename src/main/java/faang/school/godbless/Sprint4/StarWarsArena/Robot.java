package faang.school.godbless.Sprint4.StarWarsArena;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Robot {
    private String name;
    private int attackPower;
    private int defensePower;
    @Setter
    private int health=50;

    public Robot(String name, int attackPower, int defensePower) {
        this.name = name;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }
}
