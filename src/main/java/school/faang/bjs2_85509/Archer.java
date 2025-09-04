package school.faang.bjs2_85509;

public class Archer extends Character {
    private final Integer strength = 3;
    private final Integer agility = 10;
    private final Integer intellegence = 5;

    public Archer(String name) {
        super(name);
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
