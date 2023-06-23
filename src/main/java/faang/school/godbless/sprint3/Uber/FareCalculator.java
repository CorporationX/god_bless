package faang.school.godbless.sprint3.Uber;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double dist, double time, BiFunction act){
        //за беспелатно машина не приедет...
        Object res = act.apply(dist,time);
        return (double) res==0 ? 5 : (double) res;
    }
}
