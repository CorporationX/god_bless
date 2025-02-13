package school.faang.task_BJS2_56411;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public Warrior(String name, int strength, int agility, int intellect) {
        super(name, strength, agility, intellect);
    }

    @Override
    public void getDamage(Character character) {
        if (isHealthyLessZero(this.getHealth(), character.getStrength())) {
            this.setHealth(0);
        } else {
            this.setHealth(this.getHealth() - character.getStrength());
        }
    }
}
