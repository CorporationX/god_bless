package faang.school.godbless.gameHeroesOfMight;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Swordman extends Creature {

    private static final int DEFAULT_ATTACK = 8;
    private static final int DEFAULT_PROTECTION = 15;
    private static final int DEFAULT_SPEED = 20;

    public Swordman(String name) {
        super(name, DEFAULT_ATTACK, DEFAULT_PROTECTION, DEFAULT_SPEED);
    }

    public Swordman(String name, int level, int attack, int protection, int speed, int amount) {
        super(name, level, attack, protection, speed, amount);
    }

    @Override
    public int getDamage() {
        return (this.getAttack() + this.getSpeed()) * this.getLevel();
    }
}
