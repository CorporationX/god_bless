package school.faang.abstraction;

public class Archer extends Character {
    private int strength;
    private int intelligence;
    private int agility;
    private int health = 100;

    public Archer(String name) {
        super(name);
        strength = 3;
        agility = 10;
        intelligence = 5;
    }

    public Archer(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.agility);
    }
}
