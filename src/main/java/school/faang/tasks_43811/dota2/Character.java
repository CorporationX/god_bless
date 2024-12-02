package school.faang.tasks_43811.dota2;

public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int heatPoint = 100;
    private boolean alive = true;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
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

    public int getHeatPoint() {
        return heatPoint;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setHeatPoint(int heatPoint) {
        this.heatPoint = heatPoint;
        if (this.heatPoint <= 0) {
            this.heatPoint = 0;
            alive = false;
            System.out.println(name + " мертвый");
        }
    }

    public abstract void attack(Character target);

    @Override
    public String toString() {
        return "Character{"
                + "name='" + name + '\''
                + ", heatPoint=" + heatPoint
                + ", strength=" + strength
                + ", agility=" + agility
                + ", intelligence=" + intelligence
                + ", alive=" + alive
                + '}';
    }
}