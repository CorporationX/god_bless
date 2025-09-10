package school.faang.bjs2_85549;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.notDead()) {
            opponent.setHealth(opponent.getHealth() - getStrength());
        } else {
            System.out.println(opponent.getName() + " is already dead!");
        }
    }
}
