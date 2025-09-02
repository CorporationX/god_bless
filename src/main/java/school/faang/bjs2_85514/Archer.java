package school.faang.bjs2_85514;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.agility;
        System.out.println("\n" + this.name + " атакует " + opponent.getName() +
                " и наносит " + damage + " урона!");
        opponent.decreaseHealth(damage);
    }
}
