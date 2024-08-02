package faang.school.godbless.BJS2_18532;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        strength = 10;
        agility = 5;
        intelligence = 3;
    }

    @Override
    void attack(Character character) {
        character.setHealth(character.health - this.strength);
    }
}