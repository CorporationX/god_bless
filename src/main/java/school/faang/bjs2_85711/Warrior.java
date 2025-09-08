package school.faang.bjs2_85711;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {

        if (opponent == null) {
            System.out.println(getName() + " attacks thin air! No opponent to attack.");
            return;
        }

        int damage = this.getStrength();
        opponent.reduceHealth(damage);
        System.out.println(getName() + " attacks " + opponent.getName() +
                " and it does " + damage + " damage!");
    }
}
