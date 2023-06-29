package god_bless.godbless.Sprint_3_Task_Lets_Remember_The_School;

import org.w3c.dom.ls.LSOutput;

import java.util.function.Function;

public class ClassForTask {

    // Даны три стороны треугольника, вычислить его площадь
    private static Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt(x);
        /*
        //a+b
        sum.apply(a).apply(b);
        //b+c
        sum.apply(b).apply(c);
        //a+b+b+c-b=a+b+c
        sub.apply(sum.apply(a).apply(b) + sum.apply(b).apply(c)).apply(b);
        //(a+b+c)/2 = halfperimeter = p
        double halfperimeter = div.apply(sub.apply(sum.apply(a).apply(b) + sum.apply(b).apply(c)).apply(b)).apply(2.0);
        //(p-a)
        double p_a = sub.apply(halfperimeter).apply(a);
        //(p-b)
        double p_b = sub.apply(halfperimeter).apply(b);
        //(p-c)
        double p_c = sub.apply(halfperimeter).apply(c);
        //(p * (p - a))
        double firstMultiplication = mul.apply(halfperimeter).apply(p_a);
        //(p * (p - a)) * (p - b)
        double secondMultiplication = mul.apply(firstMultiplication).apply(p_b);
        //(p * (p - a) * (p - b)) * (p - c)
        double thirdMultiplication = mul.apply(secondMultiplication).apply(p_c);
        //Формула Герона sqrt(p * (p - a) * (p - b) * (p - c))
        double GeronPerimeter = sqrt.apply(thirdMultiplication);

        return GeronPerimeter;
        */
//Решение с разбора Влада
        //a+b
        sum.apply(a).apply(b);
        //a+b+c
        sum.apply(sum.apply(a).apply(b)).apply(c);
    }
    public static void main(String[] args) {
        double a = 4;
        double d = 3;
        double q = 5;
        double methodResult = triangleArea(a, d, q);
        System.out.println(methodResult);
    }
}


