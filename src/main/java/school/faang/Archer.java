package school.faang;

public class Archer extends Character{
    private int power = 3;
    private int dexterity = 10;
    private int intelligence = 5;

    public Archer(String name) {
        super(name);
    }

    public Archer(String name, int power, int dexterity, int intelligence) {
        super(name, power, dexterity, intelligence);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.dexterity;
    }
}
