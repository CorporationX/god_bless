package school.faang.task_56528;


public class Archer extends Character {

    public Archer(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(getDexterity());
    }
}
