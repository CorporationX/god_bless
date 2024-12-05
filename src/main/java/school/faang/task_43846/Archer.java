package school.faang.task_43846;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.power = 3;
        this.dexterity = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - dexterity);

        System.out.println();
        System.out.println(name + " сaused damage " + character.getName() + " on " + dexterity);
    }
}
