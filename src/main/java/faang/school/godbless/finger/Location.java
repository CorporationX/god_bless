package faang.school.godbless.finger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Location {
    private long x;
    private long y;

    public static long distance(Location l1, Location l2) {
        return Math.abs(l1.x - l2.x) + Math.abs(l2.y + l2.y);//для упрощения механик игры будем считать,
        // что геральд не умеет ходить наискосок
    }
}
