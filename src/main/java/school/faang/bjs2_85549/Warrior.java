package school.faang.bjs2_85549;

public class Warrior extends Character {
    @Override
    public void attack(Character opponent) {
        super.attack(opponent);
        if (opponent.notDead()) {
            opponent.setHealth(opponent.getHealth() - getStrength());
        } else {
            System.out.println(opponent.getName() + " is already dead!");
        }
    }

    public Warrior(String name) {
        super(name, 10, 5, 3);

    }
}
