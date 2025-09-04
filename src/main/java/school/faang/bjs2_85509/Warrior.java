package school.faang.bjs2_85509;

public class Warrior extends Character {
    private final Integer strength = 10;
    private final Integer agility = 5;
    private final Integer intellegence = 3;

    public Warrior(String name) {
        super(name);
    }

    @Override
    void attack(Character opponent) {
        if (opponent.getHealth() > 0) {
            System.out.println("\nWarrion attack opponent");
            System.out.println("Warrior damage - " + strength);
            opponent.setHealth(opponent.getHealth() - strength);
            System.out.println("Opponent health - " + opponent.getHealth());
        }
    }
}
