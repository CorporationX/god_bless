package school.faang.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    protected void attack(Character opponent) {
        if (opponent.getHealth() > 0) {
            opponent.updateHealth(this.getStrength());
        } else {
            System.out.println(opponent.getName() + " уже повержен");
        }
    }
}
