package school.faang;

public class Warrior extends Character{

    private int power = 10;
    private int dexterity = 5;
    private int intelligence = 3;

    public Warrior(String name) {
        super(name);
    }
    public Warrior(String name, int power, int dexterity, int intelligence) {
        super(name, power, dexterity, intelligence);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.power;
    }
}
