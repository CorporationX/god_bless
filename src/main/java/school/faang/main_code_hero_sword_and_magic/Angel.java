package school.faang.main_code_hero_sword_and_magic;

public class Angel extends Creature {
    public Angel(String name) {
        super(name, 2, 2, 1, 2);
    }

    @Override
    public int getDamage() {
        return getAttack();
    }
}
