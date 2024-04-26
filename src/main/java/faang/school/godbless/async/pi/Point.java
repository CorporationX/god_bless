package faang.school.godbless.async.pi;

public record Point(double x, double y) {
    public boolean isInCircle(double r) {
        return Math.sqrt(x*x + y*y) <= r;
    }
}
