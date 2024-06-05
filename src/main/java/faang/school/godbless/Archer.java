package faang.school.godbless;

public class Archer extends Character {
    public Archer(String name) {
        super(name);

        this.strength = 3;
        this.agility = 10;
        this.intelligence = 5;
    }

    @Override
    void attack(Character character) {
        character.setHealth(Math.max(character.getHealth() - this.getAgility(), 0));
    }
}
