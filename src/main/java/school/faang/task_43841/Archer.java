package school.faang.task_43841;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5); // Сила = 3, Ловкость = 10, Интеллект = 5
    }

    @Override
    public void attack(Character target) {
        int damage = this.agility;
        System.out.println(this.name + " shoots at " + target.getName() + " with dexterity " + damage);
        target.health -= damage;
        target.checkHealth();
    }
}