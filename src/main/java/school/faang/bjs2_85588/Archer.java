package school.faang.bjs2_85588;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
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
