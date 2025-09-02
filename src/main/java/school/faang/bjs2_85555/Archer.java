package school.faang.bjs2_85555;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.agility = 10;
        this.intelligence = 5;
    }

    public Archer(String name, int strength, int dexterity, int intelligence) {
        super(name, strength, dexterity, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        opponent.reduceHealth(agility);
    }

    @Override
    public String toString() {
        return "Лучник " + name + " [Сила: " + strength + ", Ловкость: " + agility +
                ", Интеллект: " + intelligence + ", Здоровье: " + health + "]";
    }
}
