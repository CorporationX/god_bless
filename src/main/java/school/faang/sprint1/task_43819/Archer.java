package school.faang.sprint1.task_43819;

public class Archer extends Character {

    public Archer(String name, int power, int dexterity, int intellect) {
        super(name, power, dexterity, intellect);
    }

    public Archer(String name) {
        super(name);
        power = 3;
        dexterity = 10;
        intellect = 5;
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.dexterity);
    }
}
