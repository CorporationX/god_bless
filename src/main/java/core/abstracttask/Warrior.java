package core.abstracttask;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
    }

    public Warrior(String name, int strength, int agility, int intelligence) {
        super(name, 10, 5, 3);
    }

    @Override
    void attack(Character character) {
        character.setHealth(character.getHealth() - this.getHealth());
    }
}
