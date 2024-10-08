package school.faang.Abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
    }

    public Warrior(String name, int power, int dexterity, int intelligence) {
        super(name, power, dexterity, intelligence);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getPower());
    }
}
