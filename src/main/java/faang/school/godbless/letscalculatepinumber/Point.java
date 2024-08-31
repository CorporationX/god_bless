package faang.school.godbless.letscalculatepinumber;

public record Point(double x, double y) {
    public boolean isInsideCircle() {
        return x * x + y * y <= 1;
    }
}