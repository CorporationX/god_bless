package faang.school.godbless.Abstraction.model;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.health > 0) {
            opponent.health -= super.force;
        } else {
            System.out.println("the enemy is dead");
        }
    }

}
