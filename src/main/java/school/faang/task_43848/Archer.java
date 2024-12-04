package school.faang.task_43848;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.strength = CharactersStats.ARCHER_STRENGTH;
        this.agility = CharactersStats.ARCHER_AGILITY;
        this.intelligence = CharactersStats.ARCHER_INTELLIGENCE;
    }

    @Override
    public void attack(Character defender) {
        System.out.println(this.getClass().getSimpleName() + " attacks " + defender.getClass().getSimpleName());
        defender.setHealth(defender.getHealth() - this.agility);
    }
}
