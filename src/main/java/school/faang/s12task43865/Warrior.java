package school.faang.s12task43865;

public class Warrior extends Character {

    private static final int STRENGTH = 10;
    private static final int AGILITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    void attack(Character opponent) {
        if (opponent.health <= strength) {
            throw new IllegalArgumentException("The health of opponent is expired");
        }
        opponent.health -= strength;
        System.out.println("Атака завершена. Урон героя: " + strength + ". Урон противника: " + opponent.getStrength());
        System.out.println("Здоровье героя: " + health + ". Здоровье противника: " + opponent.getHealth());
    }
}