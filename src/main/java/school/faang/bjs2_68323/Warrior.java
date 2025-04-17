package school.faang.bjs2_68323;

public class Warrior extends Character {

    private static final int STRENGTH = 10;
    private static final int AGILITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s атакует %s с силой %d%n", this.name, opponent.getName(), this.strength);
        opponent.reduceHealth(this.strength);
    }
}