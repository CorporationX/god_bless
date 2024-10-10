package school.faang.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character enemy) {
        System.out.println("\n"+this.getName()+" deals "+this.strength+" damage to "+enemy.getName());
        enemy.health -= this.strength;
        System.out.println(enemy.getName()+"'s health is reduced to "+enemy.health);
    }
}
