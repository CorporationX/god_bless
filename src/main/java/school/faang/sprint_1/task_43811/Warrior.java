package school.faang.sprint_1.task_43811;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 12, 5, 3);
    }

    @Override
    protected void attacksHero(Character target) {
        useDamage(target, this.getStrength());
    }
}
