package school.faang.bjs2_85711;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        // Проверка на null
        if (opponent == null) {
            System.out.println(getName() + " shoots at nothing! No target available.");
            return;
        }

        int damage = this.getAgility();
        opponent.reduceHealth(damage);
        System.out.println(getName() + " shoots " + opponent.getName() +
                " and it does " + damage + " damage!");
    }

    @Override
    public String toString() {
        return "Archer: " + super.toString();
    }
}