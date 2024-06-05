package faang.school.godbless;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);

        this.strength = 10;
        this.agility = 5;
        this.intelligence = 3;
    }

    @Override
    void attack(Character character) {
        character.setHealth(Math.max(character.getHealth() - this.getStrength(), 0));
    }
}
