package faang.school.godbless.heroes.creature;

public class Griffin extends Creature {

    private static final double LEVEL_DEPENDENCY_COEFFICIENT = 1.12;

    public Griffin() {
        this.name = "griffin";
        this.level = 3;
        this.attack = 7;
        this.protection = 20;
        this.speed = 7;
    }

    @Override
    public int getDamage() {
        return (int) (quantity * attack * level * LEVEL_DEPENDENCY_COEFFICIENT);
    }
}
