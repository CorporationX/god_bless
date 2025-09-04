package school.faang.bjs2_85588;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        setStrength(3);
        setAgility(10);
        setIntelligence(5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - getStrength());
        if (!(opponent.getHealth() <= 0)) {
            System.out.printf("По %s, наносят точный выстрел по %s у него остается %dхп!\n",
                    opponent.getName(), getName(), opponent.getHealth());
        } else {
            System.out.println(opponent.getName() + " повержен!");
        }
    }
}
