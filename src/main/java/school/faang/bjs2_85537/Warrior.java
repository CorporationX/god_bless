package school.faang.bjs2_85537;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public Warrior(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s attack %s\n", getName(), opponent.getName());
        opponent.receiveDamage(getStrength());
        System.out.printf("%s has %d HP\n", opponent.getName(), opponent.getHealth());
    }
}
