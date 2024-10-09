package faang.school.godbless.characters;

public class Archer extends Character {
    public static final int DEFAULT_FORCE = 3;
    public static final int DEFAULT_AGILITY = 10;
    public static final int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, DEFAULT_FORCE, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.decreaseHealth(this.getAgility());
    }

}
