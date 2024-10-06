package school.faang.main_code;

public class Angel extends Creature {
    public Angel(String name) {
        super(name, 2, 2, 1, 2);
    }

    @Override
    public int getDamage() {
        return getAttack();
    }
}
