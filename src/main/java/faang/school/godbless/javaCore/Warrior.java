package faang.school.godbless.javaCore;

public class Warrior extends Character {

    private final static int STRANGE = 10;
    private final static int SKILL = 5;
    private final static int INTELLECT = 3;

    public Warrior(String name) {
        super(name, STRANGE, SKILL, INTELLECT);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - STRANGE);
    }
}
