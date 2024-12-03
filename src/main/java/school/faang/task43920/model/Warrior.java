package school.faang.task43920.model;

public class Warrior extends Character {

    private final static int STRENGTH = 10;
    private final static int AGILITY = 5;
    private final static int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.strength;
    }
}
