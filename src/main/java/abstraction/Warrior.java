package abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public Warrior(String name, int power, int skill, int intellect) {
        super(name, power, skill, intellect);
    }

    @Override
    public void attack(Character character) {
        character.health = character.health - this.power;
    }
}
