package school.faang.bjs2_85711;

public class Archer extends Character {
    private static final int WARRIOR_STRENGTH = 3;
    private static final int WARRIOR_AGILITY = 10;
    private static final int WARRIOR_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
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