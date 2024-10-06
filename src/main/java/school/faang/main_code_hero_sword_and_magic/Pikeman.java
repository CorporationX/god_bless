package school.faang.main_code_hero_sword_and_magic;

public class Pikeman extends Creature {
    public Pikeman(String name) {
        super(name, 2, 3, 4, 5);
    }

    @Override
    public int getDamage() {
        return getAttack();
    }
}
