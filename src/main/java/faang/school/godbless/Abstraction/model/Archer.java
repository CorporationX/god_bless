package faang.school.godbless.Abstraction.model;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.health > 0) {
            opponent.health -= super.dexterity;
        } else {
            System.out.println("the enemy is dead");
        }
    }

}
