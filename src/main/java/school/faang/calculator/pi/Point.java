package school.faang.calculator.pi;

import lombok.Data;

@Data
public class Point {
    @SuppressWarnings("checkstyle:MemberName")
    private final double x;
    @SuppressWarnings("checkstyle:MemberName")
    private final double y;

    public boolean isInsideCircle() {
        return x * x + y * y <= 1;
    }

}
