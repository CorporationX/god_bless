package school.faang.bjs2_85588;

public class Warrior extends Character {

    private static final int WARIOR_DEFAUL_STRENGHT = 10;
    private static final int WARIOR_DEFAUL_AGILITY = 5;
    private static final int WARIOR_DEFAUL_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, WARIOR_DEFAUL_STRENGHT, WARIOR_DEFAUL_AGILITY, WARIOR_DEFAUL_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.isAlive()) {
            opponent.health = (opponent.getHealth() - getStrength());
            int currentHealth = Math.max(opponent.getHealth(), 0);
            System.out.printf("По %s, наносит сокрущающий выпад %s! У %s остается %dхп\n",
                    opponent.getName(), getName(), opponent.getName(), currentHealth);
        }
    }
}
