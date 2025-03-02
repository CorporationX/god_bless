package school.faang.task_61105;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import static school.faang.task_61105.Main.PRICE_PRECISION;
import static school.faang.task_61105.RoundDouble.roundDouble;

@Getter
@EqualsAndHashCode
public class Good {
    private final String goodName;
    private final double goodPrice;

    public Good(String goodName, double goodPrice) {
        this.goodName = goodName;
        this.goodPrice = roundDouble(goodPrice, PRICE_PRECISION);
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", goodName, goodPrice);
    }
}