package school.faang.sprint_1.task_43820;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        power = 10;
        dexterity = 5;
        intelligence = 3;
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - power);
    }
}
