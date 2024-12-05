package school.faang.task_43884;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        if (character.getHealth() > 0) {
            character.setHealth(character.getHealth() - strength);
        } else {
            System.out.println("Противник убит!");
        }
    }
}