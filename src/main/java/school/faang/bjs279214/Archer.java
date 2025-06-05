package school.faang.bjs279214;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public Archer(String name, int strength, int dexterity, int intellect) {
        super(name, strength, dexterity, intellect);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.getHealth() != 0) {
            opponent.setHealth(opponent.getHealth() - dexterity);
            if (opponent.getHealth() < 0) {
                opponent.setHealth(0);

            }
            System.out.println("Противник получил урон.");
            System.out.println("Оставшееся HP у " + opponent.getName() + " " + opponent.getHealth());
        }
        if (opponent.getHealth() == 0) {
            System.out.println("Противник умер хватит его бить");
        }
    }
}