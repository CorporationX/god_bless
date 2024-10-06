package school.faang.main_code;

public class Griffin extends Creature {
    public Griffin(String name) {
        super(name, 3, 5, 6, 3);
    }

    @Override
    public int getDamage() {
        return getAttack();
    }
}
