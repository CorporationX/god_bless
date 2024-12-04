package school.faang.task_43813;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        health -= opponent.power;
        opponent.health -= power;
        System.out.println("Атака! Урон героя: " + power + ". Урон врага: " + opponent.power);
        System.out.println("Здороье героя: " + health + ". Здоровье врага: " + opponent.health);
    }
}
