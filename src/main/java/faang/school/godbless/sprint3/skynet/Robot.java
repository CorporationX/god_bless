package faang.school.godbless.sprint3.skynet;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Robot {
    private Robot target;
    private int strength;
    private int health;

    public Robot(int strength, int health) {
        this.strength = strength;
        this.health = health;

    }

    public synchronized String attack(Robot target) {
        target.setHealth(target.getHealth() - this.getStrength());
        System.out.println("Target health" + target.getHealth());
        return "Target health" + target.getHealth();
    }

}
