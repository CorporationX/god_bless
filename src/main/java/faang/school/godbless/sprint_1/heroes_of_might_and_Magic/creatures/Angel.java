package faang.school.godbless.sprint_1.heroes_of_might_and_Magic.creatures;

public class Angel extends Creature {
    private static final int ATTACK = 7;
    private static final int DEFENSE = 21;
    private static final int SPEED = 7;

    public Angel(String name, int level, int count) {
        super(name, level, ATTACK, DEFENSE, SPEED, count);
    }

    @Override
    public int getDamage() {
        return this.getAttack() + this.getSpeed() + this.getLevel();
    }
}
