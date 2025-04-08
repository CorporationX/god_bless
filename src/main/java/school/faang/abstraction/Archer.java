package school.faang.abstraction;

public class Archer extends school.faang.abstraction.Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public Archer(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(getName() + " attacks " + opponent.getName());
        opponent.setHealth(getAgility());
    }
}