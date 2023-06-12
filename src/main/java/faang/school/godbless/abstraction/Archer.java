package faang.school.godbless.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
    }

    public Archer(String name, int strength, int dexterity, int intellect) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character goal) {
        int harm = getDexterity();
        goal.setHealth(goal.getHealth() - harm);
    }

}
