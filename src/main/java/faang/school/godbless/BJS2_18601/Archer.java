package faang.school.godbless.BJS2_18601;

public class Archer extends Character {


    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character c) {
        c.setHealth(c.getHealth() - this.dexterity);
    }
}
