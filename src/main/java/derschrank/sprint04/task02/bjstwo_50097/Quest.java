package derschrank.sprint04.task02.bjstwo_50097;

public record Quest(
    String name,
    int difficulty,
    int reward
) {
    @Override
    public String toString() {
        return String.format("%s [difficulty: %d, reward: %d]", name, difficulty, reward);
    }
}
