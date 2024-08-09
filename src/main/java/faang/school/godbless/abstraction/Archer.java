package faang.school.godbless.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.power = 3;
        this.agility = 10;
        this.intellect = 5;
    }

    public void attack(Character otherCharacter) {
        if (otherCharacter.hp >= this.agility) {
            otherCharacter.hp -= this.agility;
        } else {
            otherCharacter.hp = 0;
        }
    }
}
