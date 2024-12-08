package school.faang.task_43840;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        strength = 10;
        agility = 5;
        intellect = 3;
    }

    @Override
    public void attack(Character character) {
        if (character != null) {
            character.reduceHealth(strength);
        }
    }
}
