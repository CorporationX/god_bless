package school.faang.bjs2_72288;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class IntegerPair {

    private final int firstValue;
    private final int secondValue;

    public IntegerPair(int firstValue, int secondValue) {
        if (firstValue > secondValue) {
            this.firstValue = firstValue;
            this.secondValue = secondValue;
        } else {
            this.firstValue = secondValue;
            this.secondValue = firstValue;
        }
    }
}
