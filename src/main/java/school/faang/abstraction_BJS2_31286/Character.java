package school.faang.abstraction_BJS2_31286;

public abstract class Character {
    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);

    public void showInfoAboutCharacterHealth(){
        System.out.println(name + " health is " + health);
    }
}
