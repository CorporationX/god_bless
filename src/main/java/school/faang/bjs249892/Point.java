package school.faang.bjs249892;

public class Point {

    private double x;
    private double y;

    public boolean isInsideCircle() {
        return x * x + y * y <= 1;
    }

}
