package school.faang.bjs2_68323;

public class Archer extends Character {

    private static final int STRENGTH = 3;
    private static final int AGILITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s стреляет в %s с ловкостью %d%n", this.name, opponent.getName(), this.agility);
        opponent.reduceHealth(this.agility);
    }
}