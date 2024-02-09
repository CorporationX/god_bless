package faang.school.godbless;

public class Warrior extends Character {
    public static final int POWER_OF_Warrior = 10;
    public static final int AGILITY_OF_Warrior = 5;
    public static final int INTELLECT_OF_Warrior = 3;

    public Warrior(String name) {
        super(name, POWER_OF_Warrior, AGILITY_OF_Warrior, INTELLECT_OF_Warrior);
    }

    @Override
    public void attack(Character targetCharacter) {
        targetCharacter.health -= POWER_OF_Warrior;
    }

}
