package school.faang.bjs2_85549;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.notDead()) {
            opponent.setHealth(opponent.getHealth() - getAgility());
        } else {
            System.out.println(opponent.getName() + " is already dead!");
        }
    }
}
