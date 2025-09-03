package school.faang.bjs2_85555;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        setStrength(10);
        setAgility(5);
        setIntelligence(3);
    }

    public Warrior(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        opponent.reduceHealth(getStrength());
    }

    @Override
    public String toString() {
        return "Воин " + getName() + " [Сила: " + getStrength() + ", Ловкость: " + getAgility() +
                ", Интеллект: " + getIntelligence() + ", Здоровье: " + getHealth() + "]";
    }
}
