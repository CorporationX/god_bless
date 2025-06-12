package school.faang.bjs2_79192;

public class Warrior extends Character {

    private static final int WARRIOR_STRENGTH = 10;
    private static final int WARRIOR_AGILITY = 5;
    private static final int WARRIOR_INTELLIGENCE = 3;

    protected Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.health -= WARRIOR_STRENGTH;
        if (opponent.isDeath()) {
            System.out.println(name + " Победил ");
        }
    }
}
