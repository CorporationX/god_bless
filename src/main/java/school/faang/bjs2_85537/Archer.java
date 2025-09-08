package school.faang.bjs2_85537;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public Archer(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s attack %s\n", getName(), opponent.getName());
        opponent.receiveDamage(getAgility());
        System.out.printf("%s has %d HP\n", opponent.getName(), opponent.getHealth());
    }
}
