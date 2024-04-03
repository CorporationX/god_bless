package faang.school.godbless.heroes_of_might_and_Magic.unit;

public class Griffin extends Creature {

    private static final int ATTACK = 4;
    private static final int DEFENSE = 20;
    private static final int SPEED = 4;

    public Griffin(String name, int level, int count) {
        super(name, level, ATTACK, DEFENSE, SPEED, count);
    }

    @Override
    public int getDamage() {
        return this.getAttack() + this.getSpeed() + this.getLevel();
    }

}
