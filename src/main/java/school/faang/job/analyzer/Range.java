package school.faang.job.analyzer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Range {
    private final int lowerBound;
    private final int upperBound;

    public Range(int lowerBound) {
        this.lowerBound = lowerBound;
        this.upperBound = Integer.MAX_VALUE;
    }

    public boolean inRange(int value) {
        return value >= lowerBound && value <= upperBound;
    }

    @Override
    public String toString() {
        return lowerBound + "-" + upperBound + " руб";
    }
}
