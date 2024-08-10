package faang.school.godbless.abstraction;

public class Warrior extends Character {

    private static final int BASE_POWER = 10;
    private static final int BASE_AGILITY = 5;
    private static final int BASE_INTELLECT = 3;

    public Warrior(String name) {
        super(name);
        this.power = BASE_POWER;
        this.agility = BASE_AGILITY;
        this.intellect = BASE_INTELLECT;
    }

    public void attack(Character otherCharacter) {
        if (otherCharacter.hp >= this.power) {
            otherCharacter.hp -= this.power;
        } else {
            otherCharacter.hp = 0;
        }
    }
}
