package school.faang.task_43813;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        health -= opponent.dexterity;
        opponent.health -= dexterity;
        System.out.println("Атака! Урон герою: " + dexterity + ". Урон врагу: " + opponent.dexterity);
        System.out.println("Здороье героя: " + health + ". Здоровье врага: " + opponent.health);
    }
}
