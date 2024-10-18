package school.faang.bjs2_35389.util;

import lombok.Data;

@Data
public class PairInteger {
    private final Integer one;
    private final Integer two;

    @Override
    public String toString() {
        return "(" + one + "," + two + ")";
    }
}
