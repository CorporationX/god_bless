package faang.school.godbless.lambda.task12uber;

import lombok.Data;
import lombok.Getter;

import java.util.function.BiFunction;

@Data
public class FareCalculator {
    @Getter
    private static BiFunction<Integer,Integer,Integer> tariffEco = (s, t) -> s*t/100;
    @Getter
    private static BiFunction<Integer,Integer,Integer> tariffComfort = (s, t) -> s*t/50;
    @Getter
    private static BiFunction<Integer,Integer,Integer> tariffSuper = (s, t) -> s*t/10;

    public static int calculator(int s, int t, BiFunction<Integer,Integer,Integer> tariff){
        return tariff.apply(s,t);
    }


}
