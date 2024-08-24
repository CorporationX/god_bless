package faang.school.godbless.fi.matrix;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode
public class Coordinates {

    private final int x;
    private final int y;

    @Setter
    private boolean isSwappedToVertical = false;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
