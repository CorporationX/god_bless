package faang.school.godbless.bjs218878;

public class Archer extends Character {
    public Archer (String name) {
        super(name);
        this.strength = 3;
        this.agility = 10;
        this.intelligence = 5;
    }

    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.agility);
    }
}
