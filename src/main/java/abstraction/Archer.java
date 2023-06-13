package abstraction;

public class Archer extends Character{
    public Archer(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character enemy) {
        int damage = this.agility;
        inflictDamage(enemy, damage);
        System.out.println(this.getName() + " attacks " + enemy.getName() + " with agility " + damage);
    }
}
