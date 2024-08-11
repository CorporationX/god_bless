package faang.school.godbless.BJS2_18843;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        super.strength = 3;
        super.dexterity = 10;
        super.intelligence = 5;
    }

    public void attack(Character enemy) {
        int enemyHealth = enemy.getHealth() - this.getDexterity();
        if (enemyHealth < 0) {
            enemy.setHealth(0);
            System.out.println("The enemy is dead!");
        } else {
            enemy.setHealth(enemyHealth);
        }
    }
}
