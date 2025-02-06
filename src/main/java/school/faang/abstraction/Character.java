package school.faang.abstraction;

public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    public static int HP = 100;

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setIntelligence(int intellegence) {
        this.intelligence = intellegence;
    }

    public Character(String name) {
        this.name = name;
        setStrength(5);
        setAgility(5);
        setIntelligence(5);
        if (HP <= 0) {
            System.out.println("Character is dead");
        }
    }

    public Character(String name, int strength, int agility, int intellegence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intellegence;
        if (HP <= 0) {
            System.out.println("Character is dead");
        }
    }

    abstract void attack(Character opponent);
}
