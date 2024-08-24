package faang.school.godbless.putyourfingeronthepath;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Location {
    private final int x;
    private final int y;

    public double distanceTo(Location otherLocation) {
        return Math.sqrt(
                Math.pow(this.x - otherLocation.getX(), 2) +
                        Math.pow(this.y - otherLocation.getY(), 2));
    }
}