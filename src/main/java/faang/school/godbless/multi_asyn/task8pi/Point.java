package faang.school.godbless.multi_asyn.task8pi;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Point {
    double x;
    double y;

    boolean isInside() {
        return x * x + y * y <= 1;
    }
}
