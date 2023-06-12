package abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        super.power = 10;
        super.agility = 5;
        super.intelligence = 3;
    }

    @Override
    public void attack(Character enemy) {
        int damage = this.power;
        inflictDamage(enemy, damage);
        System.out.println(this.getName() + " attacks " + enemy.getName() + " with strength " + damage);
    }

    private static void inflictDamage(Character enemy, int damage) {
        enemy.setHealth(enemy.getHealth() - damage);
    }
}
