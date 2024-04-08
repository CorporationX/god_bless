package faang.school.godbless.abstraction_abstraction;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character target) {
        int damage = this.power;
        target.health -= damage;
        System.out.println(this.name + " наносит урон " + target.name + "у на " + damage + " единиц");
    }
}
