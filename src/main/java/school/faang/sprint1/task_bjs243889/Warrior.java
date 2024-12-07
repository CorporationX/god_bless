package school.faang.sprint1.task_bjs243889;

public class Warrior extends Character {
    private static final Integer DEFAULT_STRENGTH = 10;
    private static final Integer DEFAULT_AGILITY = 5;
    private static final Integer DEFAULT_INTELLECT = 3;

    @Override
    public void attack(Character character) {
        if (character.getHealth() > 0) {
            character.setHealth(character.getHealth() - DEFAULT_STRENGTH);
        } else {
            System.out.println("Enemy killed");
        }
    }

    public Warrior(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLECT);

    }

}
