package faang.school.godbless.remeberschool;

import com.sun.source.tree.BreakTree;

import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Double res = triangleArea(3.0, 4.0, 5.0);
        System.out.println(res);
    }

    public static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);
        Double halPeremetr = 0.0;
        Function<Double, Double> actionA = sum.apply(a);
        Function<Double, Double> actionB = sum.apply(b);
        Function<Double, Double> actionC = sum.apply(c);
        Function<Double, Double> sumOfSides = div.apply(actionA.apply(actionB.apply(actionC.apply(0.0))));
        halPeremetr = sumOfSides.apply(2.0);
        Double firstSentence = sub.apply(halPeremetr).apply(a);
        Double secondSentence = sub.apply(halPeremetr).apply(b);
        Double thirdSentence = sub.apply(halPeremetr).apply(c);
        Double totalMultiplySentence = mul.apply(firstSentence).apply(secondSentence);
        totalMultiplySentence = mul.apply(totalMultiplySentence).apply(thirdSentence);
        totalMultiplySentence = mul.apply( totalMultiplySentence).apply(halPeremetr);
        return sqrt.apply(totalMultiplySentence);
    }
}
