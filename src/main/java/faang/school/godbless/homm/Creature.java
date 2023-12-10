package faang.school.godbless.homm;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Creature {
    protected String name;
    protected int quantity = 0;
    protected int atk;
    protected int def;
    protected int spd;

    protected int getDamage() {
        return this.atk;
    }
}
