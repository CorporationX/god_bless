package school.faang.sprint_4.task_49884;

public record Point(double x, double y) {

    public boolean isInsideCircle() {
        return x * x + y * y <= 1;
    }
}
