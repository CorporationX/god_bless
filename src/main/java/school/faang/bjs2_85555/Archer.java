package school.faang.bjs2_85555;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        setStrength(3);
        setAgility(10);
        setIntelligence(5);
    }

    public Archer(String name, int strength, int dexterity, int intelligence) {
        super(name, strength, dexterity, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        opponent.reduceHealth(getAgility());
    }

    @Override
    public String toString() {
        return "Лучник " + getName() + " [Сила: " + getStrength() + ", Ловкость: " + getAgility() +
                ", Интеллект: " + getIntelligence() + ", Здоровье: " + getHealth() + "]";
    }
}
