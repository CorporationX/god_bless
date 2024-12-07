package school.faang.s12task43865;

public class Archer extends Character {

    private static final int STRENGTH = 3;
    private static final int AGILITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    void attack(Character opponent) {
        health -= opponent.agility;
        opponent.health -= agility;
        System.out.println("Атака завершена. Урон героя: " + agility + ". Урон противника: " + opponent.agility);
        System.out.println("Здоровье героя: " + health + ". Здоровье противника: " + opponent.health);
    }
}
