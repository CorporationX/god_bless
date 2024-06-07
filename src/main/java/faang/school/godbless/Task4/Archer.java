package faang.school.godbless.Task4;

public class Archer extends Character{

    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.agility = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character otherChar) {
        otherChar.health = otherChar.health - this.agility;
    }

}
