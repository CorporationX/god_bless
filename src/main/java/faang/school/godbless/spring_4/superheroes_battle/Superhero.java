package faang.school.godbless.spring_4.superheroes_battle;

public class Superhero {
    private final String name;
    private final int strength;
    private final int agility;

    public Superhero(String name, int strength, int agility) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }
}
