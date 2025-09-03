package school.faang.bjs2_85543;

import lombok.Getter;


public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    public Character(String name) {
        this.name = name;
        this.strength = 11;
        this.agility = 5;
        this.intelligence = 5;
        this.health = 100;
    }

    public Character(int strength, int agility, int intelligence) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = 100;
    }

    public void setHealth(int health) {

        if (health <= 0) {
            this.health = 0;
            System.out.println(this.name + ":I'm died");
        } else {
            System.out.println(this.getName() + "'s health remains "
                    + health);
            this.health = health;
        }
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

    public abstract void attack(Character opponent);

}
