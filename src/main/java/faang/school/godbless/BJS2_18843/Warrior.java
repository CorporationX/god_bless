package faang.school.godbless.BJS2_18843;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        super.strength = 10;
        super.dexterity = 5;
        super.intelligence = 3;
    }

    public void attack(Character enemy) {
        int enemyHealth = enemy.getHealth() - this.getStrength();
        if (enemyHealth < 0) {
            enemy.setHealth(0);
            System.out.println("The enemy is dead!");
        } else {
            enemy.setHealth(enemyHealth);
        }
    }
}
