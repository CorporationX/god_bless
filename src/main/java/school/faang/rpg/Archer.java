package school.faang.rpg;

public class Archer extends Character {
    @Override
    public void attack(Character opponent) {
        int damage = this.agility;
        opponent.health -= damage;
        opponent.validateHealth();
        System.out.printf("%s нанес %d урона , у врага осталось %d здоровья%n", this.name, damage, opponent.health);
    }

    public Archer(String name) {
        super(name, 3, 10, 5);
    }
}
