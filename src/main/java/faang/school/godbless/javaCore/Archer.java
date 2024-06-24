package faang.school.godbless.javaCore;

public class Archer extends Character {

    private final static int STRANGE = 3;
    private final static int SKILL = 10;
    private final static int INTELLECT = 5;

    public Archer(String name) {
        super(name, STRANGE, SKILL, INTELLECT);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - SKILL);
    }
}
