package game;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(name + " attacks " + opponent.getName() + " with strength " + strength);
        opponent.takeDamage(strength);
    }
}
