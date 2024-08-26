package faang.school.godbless.heroes.core.sprint.creature;

public class Angel extends Creature {

    private static final double LEVEL_DEPENDENCY_COEFFICIENT = 1.1;

    public Angel() {
        this.name = "angel";
        this.level = 5;
        this.attack = 15;
        this.protection = 30;
        this.speed = 11;
    }

    @Override
    public int getDamage() {
        return (int) (quantity * attack * level * LEVEL_DEPENDENCY_COEFFICIENT);
    }
}
