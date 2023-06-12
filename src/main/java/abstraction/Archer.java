package abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        super.power = 3;
        super.agility = 10;
        super.intelligence = 5;
    }

    @Override
    public void attack(Character enemy) {
        int damage = this.agility;
        inflictDamage(enemy, damage);
        System.out.println(this.getName() + " attacks " + enemy.getName() + " with agility " + damage);
    }

    private static void inflictDamage(Character enemy, int damage) {
        enemy.setHealth(enemy.getHealth() - damage);
    }
}
