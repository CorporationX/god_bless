package LambdaStream.bc348;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
    }

    public Archer(String name, int power, int dexterity, int iq) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character warrior) {
        warrior.health = warrior.health - dexterity;
    }
}
