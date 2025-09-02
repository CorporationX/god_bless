package school.faang.bjs2_85555;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.strength = 10;
        this.agility = 5;
        this.intelligence = 3;
    }

    public Warrior(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        opponent.reduceHealth(strength);
    }

    @Override
    public String toString() {
        return "Воин " + name + " [Сила: " + strength + ", Ловкость: " + agility +
                ", Интеллект: " + intelligence + ", Здоровье: " + health + "]";
    }
}
