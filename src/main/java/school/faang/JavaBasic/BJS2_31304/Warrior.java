package school.faang.JavaBasic.BJS2_31304;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name , 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        int damage = this.power;
        character.reduceHealth(damage);
        System.out.println(this.name + " атакует " + character.getName() + " и наносит " + damage + " урона.");
    }
}
