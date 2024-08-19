package faang.school.godbless.heroes.creature;

public class Swordman extends Creature {

    private static final double LEVEL_DEPENDENCY_COEFFICIENT = 1.3;

    public Swordman() {
        this.name = "swordman";
        this.level = 1;
        this.attack = 3;
        this.protection = 10;
        this.speed = 5;
    }

    @Override
    public int getDamage() {
        return (int) (quantity * attack * level * LEVEL_DEPENDENCY_COEFFICIENT);
    }
}
