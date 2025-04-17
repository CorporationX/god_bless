package school.faang.rpg;

public class Warrior extends Character {
    @Override
    public void attack(Character opponent) {
        int damage = this.strength;
        opponent.health -= damage;
        opponent.validateHealth();
        System.out.printf("%s нанес %d урона , у врага осталось %d здоровья%n", this.name, damage, opponent.health);
    }

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }
}
