package faang.school.godbless;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.intelligence = 5;
        this.agility = 10;
    }

    @Override
    public void attack(Character character) {
        character.health -= this.agility;
    }
}