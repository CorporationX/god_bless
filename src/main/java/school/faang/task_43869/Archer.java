package school.faang.task_43869;

public class Archer extends Character{
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public Archer(String name, Integer strength, Integer agility, Integer intelligence) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character target) {
        target.setHealth(target.getHealth() - this.agility);
    }
}