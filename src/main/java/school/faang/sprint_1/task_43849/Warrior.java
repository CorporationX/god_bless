package school.faang.sprint_1.task_43849;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        strength = 10;
        dexterity = 5;
        intelligence = 3;
    }

    public Warrior(String name, int strength, int dexterity, int intelligence) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
       character.health -= strength;
    }
}
