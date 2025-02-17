package school.faang.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        int damage = getForce();
        decreasedHealth(opponent, damage);
        System.out.println(getName() + " атакует " + opponent.getName() + " и наносит " + damage + " урона!");
    }
}