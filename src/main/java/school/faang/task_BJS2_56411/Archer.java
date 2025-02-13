package school.faang.task_BJS2_56411;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public Archer(String name, int strength, int agility, int intellect) {
        super(name, strength, agility, intellect);
    }


    @Override
    public void getDamage(Character character) {
        if (isHealthyLessZero(this.getHealth(), character.getAgility())) {
            this.setHealth(0);
        } else {
            this.setHealth(this.getHealth() - character.getAgility());
        }
    }
}
