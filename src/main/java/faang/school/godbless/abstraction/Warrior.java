package faang.school.godbless.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.power = 10;
        this.agility = 5;
        this.intellect = 3;
    }

    public void attack(Character otherCharacter) {
        if (otherCharacter.hp >= this.power) {
            otherCharacter.hp -= this.power;
        } else {
            otherCharacter.hp = 0;
        }
    }
}
