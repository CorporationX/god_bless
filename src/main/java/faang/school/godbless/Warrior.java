package faang.school.godbless;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.strength = 10;
        this.intelligence = 3;
        this.agility = 5;
    }

    @Override
    public void attack(Character character) {
        character.health -= this.strength;
    }
}
