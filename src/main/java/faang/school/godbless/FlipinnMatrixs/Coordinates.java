package faang.school.godbless.FlipinnMatrixs;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode
public class Coordinates {
    private int x;
    private int y;

    @Setter
    private boolean isSwappedToVertical = false;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
