package school.faang.task_43829;

public class Archer extends Character {
    private static final int STRENGTH = 3;
    private static final int DEXTERITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRENGTH, DEXTERITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        if (character.isDead()) {
            return;
        }
        character.health -= this.dexterity;
    }
}
