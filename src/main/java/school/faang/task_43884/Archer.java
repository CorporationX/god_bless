package school.faang.task_43884;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    protected void attack(Character character) {
        if (character.health > 0) {
            character.health -= this.agility;
        } else {
            System.out.println("Противник убит!");
        }
    }
}