package derschrank.sprint04.task14.bjstwo_49888;

public record Point(
        double x,
        double y
) {
    public boolean isInsideCircle() {
        return x * x + y * y <= 1;
    }
}
