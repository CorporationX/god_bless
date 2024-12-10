package school.faang.task_43924;

public class Warrior extends Character {

    private static final int DEFAULT_POWER = 10;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name);
        power = DEFAULT_POWER;
        agility = DEFAULT_AGILITY;
        intelligence = DEFAULT_INTELLIGENCE;
    }

    @Override
    void attack(Character character) {
        System.out.println(this.name + " ATTACK " + character.name);
        System.out.println(character.healthPoint + " - " + power);
        character.healthPoint = character.healthPoint - power;
        System.out.println(character.name + "\n" + "You health: " + character.healthPoint + "!");
        if (character.healthPoint <= 0) {
            System.out.println("You dead...");
        }
    }
}

