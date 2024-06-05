package faang.school.godbless;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        int damage = target.getStrengthPoints();
        System.out.println("Warrior нанес удар в размере" + damage);
        target.setHealthPoints(target.getHealthPoints() - damage);
    }


}





