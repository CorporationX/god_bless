package school.faang.JavaBasic.BJS2_31304;

public class Archer extends Character{
    private final int archerHealth = 100;

    public Archer(String name) {
        super(name, 3,10, 5);
    }

    @Override
    public void attack(Character character) {
        int damage = this.agility;
        character.damage(damage);
        System.out.println(this.name + " атакует " + character.getName() + " и наносит " + damage + " урона.");
    }
}
