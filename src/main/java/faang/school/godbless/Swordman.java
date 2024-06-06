package faang.school.godbless;

import lombok.ToString;

@ToString
public class Swordman extends Creature{
    public Swordman(String name, int level, int attack, int protection, int speed, int peekNumber) {
        super();
        this.name = "Swordman";
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
