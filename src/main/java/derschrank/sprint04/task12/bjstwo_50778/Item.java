package derschrank.sprint04.task12.bjstwo_50778;

public record Item(
        String name,
        int power
) {
    @Override
    public String toString() {
        return name + " (power: " + power + ")";
    }
}
