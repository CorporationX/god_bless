package school.faang.BJS2_31288;

public abstract class Character {

    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public  abstract void attack(Character opponent);

    public int getHealth(){
        return health;
    }

    public void takeDamage(int damage){
        this.health -= damage;
        if (this.health < 0){
            this.health = 0;
        }
    }

    @Override
    public String toString() {
        return name + ": Health: " +
            health + ", Strength: " +
            strength + ", Agility: " +
            agility + ", Intelligence: " +
            intelligence;
    }
}