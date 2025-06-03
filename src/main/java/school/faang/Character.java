package school.faang;

public abstract class Character {

    protected final int strenght;
    protected final int agility;
    protected final int intelligence;
    protected int health = 100;
    protected String name;


    public Character(String name) {
        this.name = name;
        strenght = 5;
        agility = 5;
        intelligence = 5;
    }

    public Character(String name, int strenght, int agility, int intelligence) {
        this.name = name;
        this.strenght = strenght;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void attack(Character opponent) {
    }

    protected boolean isDeath() {
        return health <= 0;
    }

}
