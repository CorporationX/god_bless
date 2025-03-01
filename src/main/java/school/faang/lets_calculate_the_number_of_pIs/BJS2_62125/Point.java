package school.faang.lets_calculate_the_number_of_pIs.BJS2_62125;

public record Point(double x, double y, boolean isInsideCircle) {
    public Point(double x, double y) {
        this(x, y, x * x + y * y <= 1);
    }
}
