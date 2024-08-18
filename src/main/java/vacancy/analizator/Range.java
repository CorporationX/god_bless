package vacancy.analizator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Range {
    private final double start;
    private final double end;

    public boolean isInRange(double num) {
        return num >= start && num < end;
    }

    @Override
    public String toString() {
        return start + "-" + end;
    }
}