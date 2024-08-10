package faang.school.godbless.abstraction;

public class Archer extends Character {

    private static final int BASE_POWER = 3;
    private static final int BASE_AGILITY = 10;
    private static final int BASE_INTELLECT = 5;

    public Archer(String name) {
        super(name);
        this.power = BASE_POWER;
        this.agility = BASE_AGILITY;
        this.intellect = BASE_INTELLECT;
    }

    public void attack(Character otherCharacter) {
        if (otherCharacter.hp >= this.agility) {
            otherCharacter.hp -= this.agility;
        } else {
            otherCharacter.hp = 0;
        }
    }
}
