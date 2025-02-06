package school.faang.character;

public abstract class Character {
    private String name;
    private int strength; //сила
    private int agility; //ловкость
    private int intelligence; //интеллект
    private int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = dexterity;
        this.intelligence = intelligence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Character: " +
                "name- " + name +
                ", strength- " + strength +
                ", agility- " + agility +
                ", intelligence- " + intelligence +
                ", health- " + health +
                '.';
    }

    public void attack(Character opponent) {
        if (this.health == 0) {
            System.out.println(this.getName() + " is dead. The character cannot attack anymore");
        }
        if (opponent.health < 0){
            opponent.health = 0;
        }
    }
}
