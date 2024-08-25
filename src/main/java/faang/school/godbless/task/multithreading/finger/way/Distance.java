package faang.school.godbless.task.multithreading.finger.way;

public class Distance {

    public double get(Location locationA, Location locationB) {
        double x = Math.abs(locationA.getX() - locationB.getX());
        double y = Math.abs(locationA.getY() - locationB.getY());
        return Math.round(Math.sqrt(x * x + y * y) * 100) / 100.0;
    }
}
