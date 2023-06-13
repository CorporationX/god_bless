package abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character enemy) {
        int damage = this.power;
        inflictDamage(enemy, damage);
        System.out.println(this.getName() + " attacks " + enemy.getName() + " with strength " + damage);
    }

}
