package abstraction.abstraction;

public class CharacterConfiguration {
    private static final int DEFAULT_HEALTH = 100;
    private static final int DEFAULT_CHARACTER_POWER = 5;
    private static final int DEFAULT_CHARACTER_AGILITY = 5;
    private static final int DEFAULT_CHARACTER_INTELLECT = 5;
    private static final int WARRIOR_POWER = 10;
    private static final int WARRIOR_AGILITY = 5;
    private static final int WARRIOR_INTELLECT = 3;
    private static final int ARCHER_POWER = 3;
    private static final int ARCHER_AGILITY = 10;
    private static final int ARCHER_INTELLECT = 5;

    public static int getDefaultHealt() {
        return DEFAULT_HEALTH;
    }

    public static int getDefaultCharacterPower() {
        return DEFAULT_CHARACTER_POWER;
    }

    public static int getDefaultCharacterAgility() {
        return DEFAULT_CHARACTER_AGILITY;
    }

    public static int getDefaultCharacterIntellect() {
        return DEFAULT_CHARACTER_INTELLECT;
    }

    public static int getWarriorPower() {
        return WARRIOR_POWER;
    }

    public static int getWarriorAgility() {
        return WARRIOR_AGILITY;
    }

    public static int getWarriorIntellect() {
        return WARRIOR_INTELLECT;
    }

    public static int getArcherPower() {
        return ARCHER_POWER;
    }

    public static int getArcherAgility() {
        return ARCHER_AGILITY;
    }

    public static int getArcherIntellect() {
        return ARCHER_INTELLECT;
    }
}
