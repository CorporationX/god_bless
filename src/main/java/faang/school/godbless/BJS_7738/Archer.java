package faang.school.godbless.BJS_7738;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character enemy) {
        enemy.setHealthPoints(enemy.healthPoints - this.getAgility());
        System.out.println(enemy.getName() + " has " + enemy.getHealthPoints() + " health points left ");
    }
}
