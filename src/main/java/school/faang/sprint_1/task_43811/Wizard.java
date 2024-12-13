package school.faang.sprint_1.task_43811;

public class Wizard extends Character {
    public Wizard(String name) {
        super(name, 5, 5, 10);
    }

    @Override
    protected void attacksHero(Character target) {
        useDamage(target, this.getIntelligence());
    }
}
