package school.faang;

public abstract class Character {

    protected final int strenght;
    protected final int agility;
    protected final int intelligence;
    protected int health = 100;
    protected String name;


    protected Character(String name) {
        this.name = name;
        strenght = 5;
        agility = 5;
        intelligence = 5;
    }

    protected Character(String name, int strenght, int agility, int intelligence) {
        this.name = name;
        this.strenght = strenght;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void attack(Character opponent) {
    }

    protected boolean isLive() {
        return health <= 0;
    }

}
