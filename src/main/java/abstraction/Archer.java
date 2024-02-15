package abstraction;

public class Archer extends Character{
    public Archer(String name, int power, int dexterity, int intelligence) {
        super(name, power, dexterity, intelligence);
    }
    Archer archer = new Archer("Bill", 3, 10, 5);
}
