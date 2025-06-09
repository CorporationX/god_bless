package school.faang.abstraction;

public class Archer extends Character {
    private static final int STARTER_STRENGTH = 3;
    private static final int STARTER_AGILITY = 10;
    private static final int STARTER_INTELLIGENCE = 5;


    public Archer(String name) {
        super(name);
        this.strength = STARTER_STRENGTH;
        this.agility = STARTER_AGILITY;
        this.intelligence = STARTER_INTELLIGENCE;
    }

    @Override
    public void attack(Character opponent) {
        opponent.health -= agility;
        if (opponent.isKilling()) {
            System.out.println("the archer won");
        }
    }
}
