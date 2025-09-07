package school.faang.bjs2_86440;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.getStrength();
        opponent.reduceHealth(damage);
        System.out.println(getName() + " attacks " + opponent.getName() +
                " and it does " + damage + " damage!");
    }
}