package school.faang.tasks_43811.dota2;

public class Wizard extends Character {
    public Wizard(String name) {
        super(name, 5, 5, 10);
    }

    @Override
    protected void attacksHero (Character target){
        useDamage(target, this.getIntelligence());
    }
}
