package school.faang.task_43924;

public class Archer extends Character {
    private static final int DEFAULT_POWER = 3;
    private static final int DEFAULT_AGILITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name);
        power = DEFAULT_POWER;
        agility = DEFAULT_AGILITY;
        intelligence = DEFAULT_INTELLIGENCE;
    }

    @Override
    void attack(Character character) {
        System.out.println(this.name + " ATTACKING " + character.name);
        System.out.println(character.healthPoint + " - " + agility);
        character.healthPoint = character.healthPoint - agility;
        System.out.println(character.name + "\n" + "You health: " + character.healthPoint + "!");
        if (character.healthPoint <= 0) {
            System.out.println("You dead...");
        }
    }
}
