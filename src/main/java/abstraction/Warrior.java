package abstraction;

public class Warrior extends Character{

    public Warrior(String name, int power, int dexterity, int intelligence) {
        super(name, power, dexterity, intelligence);
    }
    Warrior warrior = new Warrior("Tom", 10, 5, 3);

    @Override
    public void attack(Character character) {

    }

}
