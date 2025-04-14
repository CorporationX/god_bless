package school.faang;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public void attack(Character opponent) {
        opponent.reduseHealth(this.healthPoint);
        System.out.println(this.name + " атакует " + opponent.getName() + " и наносит " + this.agility + " урона ");
    }

}
