package faang.school.godbless.BJS2_23917;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pair {
    private final int SPEED_OF_WITCHER = 2;
    private int x;
    private int y;

    public static double countDistance(Pair pair1, Pair pair2) {
        int xDiff = pair2.getX() - pair1.getX();
        int yDiff = pair2.getY() - pair1.getY();
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public boolean lessThan(Pair other) {
        Pair origin = new Pair(0, 0);

        double thisDistance = countDistance(origin, this);
        double otherDistance = countDistance(origin, other);

        return thisDistance < otherDistance;
    }

    public double timeTo(Pair other) {
        double distance = countDistance(this, other);
        return distance / SPEED_OF_WITCHER;
    }

    @Override
    public String toString() {
        return "SPEED_OF_WITCHER: " + SPEED_OF_WITCHER + '\n' +
                "x: " + x + '\n' +
                "y: " + y + '\n';
    }
}
