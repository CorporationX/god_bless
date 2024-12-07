package school.faang.task_43885;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
    }

    public Archer(String name, int strength, int dexterity, int intelligence) {
        super(name, 3, 10, 5);
    }

    @Override
    public void getLevelAlive() {
        super.getLevelAlive();
    }

    @Override
    public void checkHealth() {
        if (this.health <= 0) {
            throw new RuntimeException();
        }
    }

    @Override
    public void attack(Character target) {

        if (target.health > 0) {
            if (this.health > 0) {
                this.health = this.health - target.strength;
                this.attack(target);
            }
        }
    }
}
