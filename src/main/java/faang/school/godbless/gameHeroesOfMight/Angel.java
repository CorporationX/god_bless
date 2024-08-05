package faang.school.godbless.gameHeroesOfMight;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Angel extends Creature {

    private static final int DEFAULT_ATTACK = 0;
    private static final int DEFAULT_PROTECTION = 30;
    private static final int DEFAULT_SPEED = 20;

    public Angel(String name) {
        super(name, DEFAULT_ATTACK, DEFAULT_PROTECTION, DEFAULT_SPEED);
    }

    public Angel(String name, int level, int attack, int protection, int speed, int amount) {
        super(name, level, attack, protection, speed, amount);
    }

    @Override
    public int getDamage() {
        return (this.getSpeed() - this.getAttack()) * this.getLevel();
    }
}
