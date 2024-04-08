package faang.school.godbless.abstraction_abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        double damage = this.power * intelligence * 0.5;
        target.health -= (int)damage;
        System.out.println(this.name + " наносит урон " + target.name + "у на " + damage + " единиц");
    }
}
