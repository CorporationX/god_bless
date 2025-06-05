package school.faang.bjs279214;

public class Warrior extends Character {


    public Warrior(String name, int strength, int dexterity, int intellect) {
        super(name, strength, dexterity, intellect);
    }

    public Warrior(String name) {
        super(name, 10, 3, 5);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.getHealth() != 0) {
            opponent.setHealth(opponent.getHealth() - strength);
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
