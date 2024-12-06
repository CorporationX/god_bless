package school.faang.task_43841;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character target) {
        if (!target.canBeAttacked()) {
            System.out.println(this.name + " cannot attack " + target.getName() + " because he is already defeated.");
            return;
        }
        System.out.println(this.name + " attacks " + target.getName() + " with strength " + this.strength);
        target.applyDamage(this.strength);
    }
}