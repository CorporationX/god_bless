package school.faang.m1s1.bsj2_32890_homm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defence;
    private int speed;
    private int damage;
    private int hp;

    public int strikeEnemy(Creature creature) {
        double damageModifier = 1;
        if (creature.getDefence() > this.attack) {
            damageModifier = 0.5;
        }
        return (int) Math.round(this.damage * damageModifier);
    }


}
