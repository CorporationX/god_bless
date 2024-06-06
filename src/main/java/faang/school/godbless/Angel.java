package faang.school.godbless;

import lombok.ToString;

@ToString
public class Angel extends Creature{
    public Angel(String name, int level, int attack, int protection, int speed, int peekNumber) {
        super();
        this.name = "Angel";
        this.level = 10;
        this.attack = 20;
        this.protection = 12;
        this.peekNumber = 1;
    }

    @Override
    int getDamage() {
        return this.getAttack();
    }
}
