package faang.school.godbless;

public class Warrior extends Character {
    public Warrior(String name){
        super(name,10,5,3);
    }

    @Override
    public void attack(Character enemy) {
        enemy.setHealthPoints(enemy.healthPoints-this.getPower());
        System.out.println(enemy.getName() + " has " + enemy.getHealthPoints() + " health points left " );
    }
}
