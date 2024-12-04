package school.faang.task_43841;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3); // Сила = 10, Ловкость = 5, Интеллект = 3
    }

    @Override
    public void attack(Character target) {
        int damage = this.strength;
        System.out.println(this.name + " attacks " + target.getName() + " by force " + damage);
        target.health -= damage;
        target.checkHealth();
    }
}