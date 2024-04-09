package faang.school.godbless.game.characters;

import faang.school.godbless.game.Creature;

public class Swordman extends Creature {
    public Swordman(int quantity) {
        super("Swordman", 2, 4, 9, 2, quantity);
    }

    @Override
    public int getDamage() {
        return getQuantity() * 5;
    }
}
