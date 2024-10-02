package dima.evseenko.abstraction.entity;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public Character attack(Character character) {
        System.out.printf("Warrior %s attacked %s%n", this.getName(), character.getName());

        character.damage(getStrength());
        return character;
    }
}
