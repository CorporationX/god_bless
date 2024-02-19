package faang.school.godbless;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        double a = 3.0;
        double b = 6.0;
        double c = 6.0;

        Main m = new Main();
        double area = m.triangleArea( a, b, c );
        System.out.println( "Triangle area: " + area );
    }

    Double triangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0 || a > c + b || b > a + c || c > a + b) {
            throw new IllegalArgumentException( "Sides of trangle must be positive and sum of one side cannot be greater then 2 other sides" );
        }

        Function<Double, Function<Double, Double>> sum = (x) -> y -> x + y;
        Function<Double, Function<Double, Double>> mul = (x) -> y -> x * y;
        Function<Double, Function<Double, Double>> sub = (x) -> y -> x - y;
        Function<Double, Function<Double, Double>> div = (x) -> y -> x / y;
        Function<Double, Double> sqrt = (x) -> Math.sqrt( x );

        double halPerimeter = div.apply( sum.apply( sum.apply( a ).apply( b ) ).apply( c ) ).apply( 2.0 );
        double perSubA = sub.apply( halPerimeter ).apply( a );
        double perSubB = sub.apply( halPerimeter ).apply( b );
        double perSubC = sub.apply( halPerimeter ).apply( c );

        double mulOfSidesAndHalPer = mul.apply( mul.apply( mul.apply( perSubA ).apply( perSubB ) ).apply( perSubC ) )
                .apply( halPerimeter );

        return sqrt.apply( mulOfSidesAndHalPer );
    }
}
