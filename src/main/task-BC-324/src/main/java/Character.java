public abstract class Character {
    protected String name;
    protected int power;
    protected int dexterity;
    protected int iq;
    protected int health = 100;

    public Character(String name){
        this.name = name;

    }

    public Character(String name, int power, int dexterity, int iq){
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.iq = iq;

    }

    public abstract void attack(Character character);
}
