package school.faang.task_43876;

public class Warrior extends Character {

    public Warrior(String name, int power, int agility, int intellect) {
        super(name);
        power = 10;
        agility = 5;
        intellect = 3;
    }

    @Override
    public void attack(Character character) {
        Warrior warrior = new Warrior(name, power, agility, intellect);
        character.setHealth(character.getHealth() - warrior.getPower());
    }
}
