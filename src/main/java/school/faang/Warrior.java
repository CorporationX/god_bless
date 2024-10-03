package school.faang;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.strength = 10;
        this.agility = 5;
        this.intellect = 3;
    }

    @Override
    void attack(Character character) {
        character.health -= this.strength;
    }
}
