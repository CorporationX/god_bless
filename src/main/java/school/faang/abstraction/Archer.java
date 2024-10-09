package school.faang.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character enemy) {
        System.out.println("\n"+this.getName()+" deals "+this.agility+" damage to "+enemy.getName());
        enemy.health -= this.agility;
        System.out.println(enemy.getName()+"'s health is reduced to "+enemy.health);
    }
}
