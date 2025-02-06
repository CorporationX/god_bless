package school.faang.task_48207;

import lombok.Getter;

import static school.faang.task_48207.Main.PRICE_PRECISION;
import static school.faang.task_48207.RoundDouble.roundDouble;

@Getter
public class Good {
    private final String goodName;
    private final double goodPrice;

    public Good(String goodName, double goodPrice) {
        this.goodName = goodName;
        this.goodPrice = roundDouble(goodPrice, PRICE_PRECISION);
    }

    @Override
    public String toString() {
        return goodName + " " + goodPrice;
    }
}