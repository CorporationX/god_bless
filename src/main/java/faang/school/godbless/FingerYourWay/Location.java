package faang.school.godbless.FingerYourWay;

import lombok.Getter;

@Getter
public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
