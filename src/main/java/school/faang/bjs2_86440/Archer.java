package school.faang.bjs2_86440;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.getAgility();
        opponent.reduceHealth(damage);
        System.out.println(getName() + " shoots " + opponent.getName() +
                " and it does " + damage + " damage!");
    }
}