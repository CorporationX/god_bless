package faang.school.godbless.gameHeroesOfMight;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Griffin extends Creature{
    private static final int DEFAULT_ATTACK = 15;
    private static final int DEFAULT_PROTECTION = 12;
    private static final int DEFAULT_SPEED = 8;

    public Griffin(String name) {
        super(name, DEFAULT_ATTACK, DEFAULT_PROTECTION, DEFAULT_SPEED);
    }

    public Griffin(String name, int level, int attack, int protection, int speed, int amount) {
        super(name, level, attack, protection, speed, amount);
    }
    @Override
    public int getDamage() {
        return (this.getAttack() + this.getSpeed()) * this.getLevel();
}
}
