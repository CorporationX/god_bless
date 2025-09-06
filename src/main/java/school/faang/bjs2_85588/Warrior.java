package school.faang.bjs2_85588;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 25, 5, 3);
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
