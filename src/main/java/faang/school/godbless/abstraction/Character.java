package faang.school.godbless.abstraction;

public abstract class Character {
    public int health = 100;
    private String name;
    private int power;
    private int agility;
    private int intelligence;
    public void setName(String setName) {
        name = setName;
    }
    public void setPower(int setPower) {
        power = setPower;
    }
    public void setAgility(int setAgility) {
        agility = setAgility;
    }
    public void setIntelligence(int setIntelligence) {
        intelligence = setIntelligence;
    }
    public String getName() {
        return name;
    }
    public int getPower() {
        return power;
    }
    public int getAgility() {
        return agility;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public Character(String setName) {
        name = setName;
    }
    protected abstract void attack(Character charter);
}




