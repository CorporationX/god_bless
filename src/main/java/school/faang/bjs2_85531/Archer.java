package school.faang.bjs2_85531;

public class Archer extends Character {
    private static final int strength = 3;
    private static final int agility = 10;
    private static final int intelligence = 5;

    public Archer(String name) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        health = health - opponent.getStrength();
        if (isKilling()) {
            System.out.println(getName() + " повержен");
            return;
        }
        System.out.println(getName() + " " + health + " ХП");
    }
}
