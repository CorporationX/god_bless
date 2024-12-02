package school.faang.sprint1.task_43819;

public class Warrior extends Character {

    public Warrior(String name, int power, int dexterity, int intellect) {
        super(name, power, dexterity, intellect);
    }

    public Warrior(String name) {
        super(name);
        power = 10;
        dexterity = 5;
        intellect = 3;
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.power);
    }
}
