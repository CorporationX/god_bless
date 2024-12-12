package school.faang.task_43926;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        this.setHealth(this.getHealth() - character.getAgility());
    }
}
