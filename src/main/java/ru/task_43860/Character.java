package ru.task_43860;

public abstract class Character {
    private int strong;
    private int dexterity;
    private int intelligence;
    private int health = 100;
    private static String name;

    public Character(int strong, int dexterity, int intelligence) {
        this.strong = strong;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public Character(String name) {
        this.name = name;
    }

    public Character() {
    }

    public int getStrong() {
        return strong;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void setStrong(int strong) {
        this.strong = strong;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int attack (Character character);

}
