package faang.school.godbless.heroes_of_might_and_Magic.creatures;

public class Swordman extends Creature {
    private static final int ATTACK = 1;
    private static final int DEFENSE = 55;
    private static final int SPEED = 3;

    public Swordman(String name, int level, int count) {
        super(name, level, ATTACK, DEFENSE, SPEED, count);
    }

    @Override
    public int getDamage() {
        return this.getAttack() + this.getSpeed() + this.getLevel();
    }
}
