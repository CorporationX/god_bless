package school.faang.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 5, 10, 0);
    }

    @Override
    public void attack(Character target) {
        System.out.println(getName() + " атакует,  " + target.getName() + "и наносит " + this.getStrength() + " урона");
        target.health-= this.getStrength();
        System.out.println(target.name + " теперь имеет  " + target.health + " здоровья");

    }
}
