package faang.school.godbless.BJS2_18601;

public class Warrior extends Character {


    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character c) {
        c.setHealth(c.getHealth() - this.strength);
    }
}
