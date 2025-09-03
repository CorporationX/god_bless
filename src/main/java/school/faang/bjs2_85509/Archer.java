package school.faang.bjs2_85509;

public class Archer extends Character {
    private static final Integer strength = 3;
    private static final Integer agility = 10;
    private static final Integer intellegence = 5;

    public Archer(String name) {
        super(name, strength, agility, intellegence);
    }

    @Override
    void attack(Character opponent) {
        if (opponent.getHealth() > 0) {
            System.out.println("\nArcher attack opponent");
            System.out.println("Archer damage - " + agility);
            opponent.setHealth(opponent.getHealth() - agility);
            System.out.println("Opponent health - " + opponent.getHealth());
        }
    }
}
