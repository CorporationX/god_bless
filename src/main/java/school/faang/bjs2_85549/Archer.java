package school.faang.bjs2_85549;

public class Archer extends Character {

    @Override
    public void attack(Character opponent) {
        super.attack(opponent);
        if (opponent.notDead()) {
            opponent.setHealth(opponent.getHealth() - getAgility());
        } else {
            System.out.println(opponent.getName() + " is already dead!");
        }
    }

    public Archer(String name) {
        super(name, 3, 10, 5);
    }
}
