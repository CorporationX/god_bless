package derschrank.sprint04.task10.bjstwo_50592;

public record Superhero(
        String name,
        int strength,
        int agility
) {
    @Override
    public String toString() {
        return String.format("%s (S:%d/A:%d)", name, strength, agility);
    }
}
