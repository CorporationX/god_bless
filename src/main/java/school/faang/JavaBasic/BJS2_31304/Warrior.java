package school.faang.JavaBasic.BJS2_31304;

public class Warrior extends Character{
    private final int warriorHealth = 100;

    public Warrior(String name) {
        super(name , 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        int damage = this.power;
        character.damage(damage);
        System.out.println(this.name + " атакует " + character.getName() + " и наносит " + damage + " урона.");
    }
}
