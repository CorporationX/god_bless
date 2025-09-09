package school.faang.bjs2_85711;

public class Warrior extends Character {
    private static final int WARRIOR_STRENGTH = 10;
    private static final int WARRIOR_AGILITY = 5;
    private static final int WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
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
