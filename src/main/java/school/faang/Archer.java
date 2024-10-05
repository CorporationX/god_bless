package school.faang;

public class Archer extends Character {
    public Archer(String name, int power, int agility, int intelligence) {
        super(3, 10, 5);
        this.name = name;
    }

    @Override
    public void attack(Character character) {
        character.health -= character.agility;
    }
}
