package derschrank.sprint04.task07.bjstwo_50256;

public record Robot(
        String name,
        int attackPower,
        int defensePower
) {
    @Override
    public String toString() {
        return String.format("%s [%d/%d]", name, attackPower, defensePower);
    }
}
