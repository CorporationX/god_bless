package school.faang.task_43848;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.strength = CharactersStats.WARRIOR_STRENGTH;
        this.agility = CharactersStats.WARRIOR_AGILITY;
        this.intelligence = CharactersStats.WARRIOR_INTELLIGENCE;
    }

    @Override
    public void attack(Character defender) {
        System.out.println(this.getClass().getSimpleName() + " attacks " + defender.getClass().getSimpleName());
        defender.setHealth(defender.getHealth() - this.strength);
    }
}
