package school.faang.sprint1.task_bjs243889;

public class Archer extends Character {
    private static final Integer DEFAULT_STRENGTH = 3;
    private static final Integer DEFAULT_AGILITY = 10;
    private static final Integer DEFAULT_INTELLECT = 5;

    @Override
    public void attack(Character character) {
        if (character.getHealth() > 0) {
            character.receiveDamage(DEFAULT_AGILITY);
        } else {
            System.out.println("Enemy killed");
        }
    }

    public Archer(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLECT);

    }

}
