package school.faang.bjs2_85588;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        setStrength(10);
        setAgility(5);
        setIntelligence(3);
    }

    @Override
    public void attack(Character opponent) {
        if (isAlive(opponent)) {
            opponent.setHealth(opponent.getHealth() - getStrength());
            int currentHealth = Math.max(opponent.getHealth(), 0);
            System.out.printf("По %s, наносит сокрущающий выпад %s! У %s остается %dхп\n",
                    opponent.getName(), getName(), opponent.getName(), currentHealth);
            isAlive(opponent);
        }
    }
}
