package school.faang.rpggame;

public class Warrior extends Character {

    private static final int DEFAULT_STRENGTH = 10;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        if (!isDead(opponent)) {
            opponent.setHealth(opponent.getHealth() - this.getStrength());
        }

        if (isDead(opponent)) {
            System.out.println("Opponent is dead!\n" + this.getName() + " win!");
        } else {
            System.out.println("Opponent health after attack : " + opponent.getHealth());
        }
    }
}
