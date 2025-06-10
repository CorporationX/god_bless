package school.faang.abstraction;

public class Warrior extends Character {

    private static final int STARTER_STRENGTH = 10;
    private static final int STARTER_AGILITY = 5;
    private static final int STARTER_INTELLIGENCE = 3;


    public Warrior(String name) {
        super(name, STARTER_STRENGTH, STARTER_AGILITY, STARTER_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.health -= strength;
        if (opponent.isKilling()) {
            System.out.println("the warrior won");
        }
    }
}
