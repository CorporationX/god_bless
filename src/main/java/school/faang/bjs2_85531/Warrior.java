package school.faang.bjs2_85531;

public class Warrior extends Character {
    private static final int strength = 9;
    private static final int agility = 5;
    private static final int intelligence = 3;

    public Warrior(String name) {
        super(name, strength, agility, intelligence);
    }


    @Override
    public void attack(Character opponent) {
        health = health - opponent.getAgility();
        if (isKilling()) {
            System.out.println(getName() + " повержен");
            return;
        }
        System.out.println(getName() + " " + health + " ХП");
    }
}
