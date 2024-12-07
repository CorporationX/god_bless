package school.faang.task_43885;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
    }


    public Warrior(String name, int strength, int dexterity, int intelligence) {
        super(name, 10, 5, 3);
    }

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
