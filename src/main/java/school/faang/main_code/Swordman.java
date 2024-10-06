package school.faang.main_code;

public class Swordman extends Creature {
    public Swordman(String name) {
        super(name, 2, 2, 4, 5);
    }

    @Override
    public int getDamage() {
        return getAttack();
    }
}
