package school.faang;

public class Warrior extends Character {
    public Warrior(String name, int power, int agility, int intelligence) {
        super(10, 5, 3);
        this.name = name;
    }

    @Override
    public void attack(Character character) {
        character.health -= character.power;
    }
}
