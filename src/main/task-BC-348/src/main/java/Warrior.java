public class Warrior extends Character{
    public Warrior(String name) {
        super(name);
    }

    public Warrior(String name, int power, int dexterity, int iq) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character archer) {
        archer.health = archer.health - power;
    }
}
