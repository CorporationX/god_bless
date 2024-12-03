package school.faang.task43920.model;

public class Archer extends Character {

    private final static int STRENGTH = 3;
    private final static int AGILITY = 10;
    private final static int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.agility;
    }
}
