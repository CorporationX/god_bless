package school.faang.bjs2_85588;

public class Archer extends Character {
    private static final int ARCHER_DEFAUL_STRENGHT = 10;
    private static final int ARCHER_DEFAUL_AGILITY = 5;
    private static final int ARCHER_DEFAUL_INTELLIGENCE = 3;

    public Archer(String name) {
        super(name, ARCHER_DEFAUL_STRENGHT, ARCHER_DEFAUL_AGILITY, ARCHER_DEFAUL_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.isAlive()) {
            opponent.health = (opponent.getHealth() - getAgility());
            int currentHealth = Math.max(opponent.getHealth(), 0);
            System.out.printf("По %s, наносят точный выстрел %s! У него остается %dхп!\n",
                    opponent.getName(), getName(), currentHealth);
        }
    }
}
