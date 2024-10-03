package school.faang.BJS2_31295;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        if (character.health < power) {
            character.health = 0;
        } else {
            character.health -= power;
        }
    }
}
