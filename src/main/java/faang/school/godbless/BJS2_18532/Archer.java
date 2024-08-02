package faang.school.godbless.BJS2_18532;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        strength = 3;
        agility = 10;
        intelligence = 5;
    }

    @Override
    void attack(Character character) {
        character.setHealth(character.health - this.agility);
    }
}