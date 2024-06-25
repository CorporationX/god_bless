package faang.school.godbless.multithreading_2.starwars;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Robot {
    @Getter
    private String name;
    private int healthPoint;
    private int attackPower;
    private int defencePower;

    public boolean isAlive() {
        return healthPoint > 0;
    }

    public void getDamage(int attackPower) {
        if (defencePower <= attackPower) {
            healthPoint = healthPoint - (attackPower - defencePower);
        }
    }

    public int attack() {
        return attackPower;
    }

}
