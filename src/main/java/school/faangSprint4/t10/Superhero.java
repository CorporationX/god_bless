package school.faangSprint4.t10;

public record Superhero(String name, int strength, int agility) {

    public int getPower() {
        return strength + agility;
    }

    @Override
    public String toString() {
        return name + " (Power: " + getPower() + ")";
    }
}