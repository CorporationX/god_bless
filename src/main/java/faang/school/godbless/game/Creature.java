package faang.school.godbless.game;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defense;
    private int speed;
    private int quantity;

    public abstract int getDamage();
}

class Pikeman extends Creature {
    public Pikeman(String name, int level, int quantity) {
        super( name, level, 10, 5, 5, quantity );
    }

    @Override
    public int getDamage() {
        return getQuantity() * (getAttack() - getDefense());
    }
}

class Griffin extends Creature {
    public Griffin(String name, int level, int quantity) {
        super( name, level, 15, 10, 8, quantity );
    }

    @Override
    public int getDamage() {
        return getQuantity() * (getAttack() - getDefense());
    }
}

class Swordman extends Creature {
    public Swordman(String name, int level, int quantity) {
        super( name, level, 20, 15, 10, quantity );
    }

    @Override
    public int getDamage() {
        return getQuantity() * (getAttack() - getDefense());
    }
}

class Angel extends Creature {
    public Angel(String name, int level, int quantity) {
        super( name, level, 30, 20, 15, quantity );
    }

    @Override
    public int getDamage() {
        return getQuantity() * (getAttack() - getDefense());
    }
}