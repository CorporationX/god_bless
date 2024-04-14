package faang.school.godbless.BJS2_4128;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {
    private String name;
    private int level;
    private int damage;
    private int defense;
    private int speed;
    private int health;

    public abstract int getAttackDamage();

    public void setFullHeath() {
        health = 100;
    }
}
