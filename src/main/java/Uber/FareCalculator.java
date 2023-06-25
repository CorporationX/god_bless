package Uber;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.BiFunction;

@Data
@AllArgsConstructor
public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> function){
        return function.apply(distance,time);
    }


}
