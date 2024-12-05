package school.faang.task_43884;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        if (character.getHealth() > 0) {
            character.setHealth(character.getHealth() - agility);
        } else {
            System.out.println("Противник убит!");
        }
    }
}