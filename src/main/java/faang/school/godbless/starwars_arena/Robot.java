package faang.school.godbless.starwars_arena;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Robot {

    private String name;
    private int attackPower;
    @Setter
    private int defencePower;
    @Setter
    private Robot target;
    @Setter
    private boolean isAlive = true;

    public Robot(String name, int attackPower, int defencePower) {
        this.name = name;
        this.attackPower = attackPower;
        this.defencePower = defencePower;
    }

    public void attack(Robot target) {
        int targetDefence = target.getDefencePower();

        if (targetDefence <= attackPower) {
            target.setAlive(false);
        } else {
            target.setDefencePower(targetDefence - attackPower);
        }
    }
}
