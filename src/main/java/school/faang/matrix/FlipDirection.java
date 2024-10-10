package school.faang.matrix;

import java.util.List;

public enum FlipDirection {
    HORIZONTAL,
    VERTICAL;

    public static List<FlipDirection> getDirections() {
        return List.of(FlipDirection.HORIZONTAL, FlipDirection.VERTICAL);
    }
}
