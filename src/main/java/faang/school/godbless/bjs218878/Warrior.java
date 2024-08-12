package faang.school.godbless.bjs218878;

public class Warrior extends Character {
    public Warrior (String name) {
        super(name);
        this.strength = 10;
        this.agility = 5;
        this.intelligence = 3;
    }

    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.strength);
    }
}
