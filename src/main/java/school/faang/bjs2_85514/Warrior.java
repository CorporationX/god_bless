package school.faang.bjs2_85514;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.strength;
        System.out.println("\n" + this.name + " атакует " + opponent.getName() +
                " и наносит " + damage + " урона!");
        opponent.decreaseHealth(damage);
    }
}
