package school.faang;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public void attack(Character opponent) {
        opponent.reduseHealth(this.healthPoint);
        System.out.println(this.name + " атакует " + opponent.getName() + " и наносит " + this.strength + " урона ");
    }
}
