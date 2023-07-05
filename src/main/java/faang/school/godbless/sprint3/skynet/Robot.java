package faang.school.godbless.sprint3.skynet;

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

    public String attack(Robot target) {
        synchronized (target) {
            target.setHealth(target.getHealth() - this.getStrength());
            System.out.println("Target health" + target.getHealth());
            return "Target health" + target.getHealth();
        }
    }

}
