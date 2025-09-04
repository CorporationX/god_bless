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
        opponent.setHealth(opponent.getHealth() - getStrength());
        if (!(opponent.getHealth() <= 0)) {
            System.out.printf("По %s, наносит сокрущающий выпад %s! у %dхп\n",
                    opponent.getName(), getName(), opponent.getHealth());
        } else {
            System.out.println(opponent.getName() + " повержен!");
        }
    }
}
