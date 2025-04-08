package school.faang.abstraction;

public class Warrior extends school.faang.abstraction.Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public Warrior(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(getName() + " attacks " + opponent.getName());
        opponent.setHealth(getStrength());
    }
}