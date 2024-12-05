package school.faang.task_43884;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    protected void attack(Character character) {
        if (character.health > 0) {
            character.health -= this.strength;
        } else {
            System.out.println("Противник убит!");
        }
    }
}