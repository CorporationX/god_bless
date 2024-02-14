package faang.school.godbless;

public class Archer extends Character {
    public static final int POWER_OF_Warrior = 3;
    public static final int AGILITY_OF_Warrior = 10;
    public static final int INTELLECT_OF_Warrior = 5;

    public Archer(String name) {
        super(name, POWER_OF_Warrior, AGILITY_OF_Warrior, INTELLECT_OF_Warrior);
    }

    public void attack(Character targetCharacter) {
        targetCharacter.health -= AGILITY_OF_Warrior;
        System.out.println(this.name + " Нанес урон противинику: " + targetCharacter.name + " " + AGILITY_OF_Warrior);
    }
}
