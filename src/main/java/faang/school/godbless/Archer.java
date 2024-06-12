package faang.school.godbless;

public class Archer extends Character {
    public Archer(String name){
        super(name, 5, 10, 5);
    }

    @Override
    public void attack(Character target) {
        int damage =  target.getAgilityPoints();
        System.out.println(" Лучник нанес удар в размере" + damage);
        target.setHealthPoints(target.getHealthPoints() - damage);
    }


}
