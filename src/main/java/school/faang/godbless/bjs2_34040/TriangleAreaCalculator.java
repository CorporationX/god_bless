package school.faang.godbless.bjs2_34040;

public class TriangleAreaCalculator {

    public Double calculateTriangleArea(double a, double b, double c) throws IllegalArgumentException {
        if (a + b < c || a + c < b || c + b < a) {
            throw new IllegalArgumentException("triangle with given sides can not exist");
        }

        double perimeter = Operations.add.apply(Operations.add.apply(a).apply(b)).apply(c); // perimeter
        double p = Operations.divide.apply(perimeter).apply((double) 2); // p = perimeter divided by 2
        double pMinusA = Operations.subtract.apply(p).apply(a); // (p-a)
        double pMinusB = Operations.subtract.apply(p).apply(b); // (p-b)
        double pMinusC = Operations.subtract.apply(p).apply(c); // (p-c)
        double pTimesPMinusA = Operations.multiply.apply(p).apply(pMinusA); // p*(p-a)
        double pMinusBTimesPMinusC = Operations.multiply.apply(pMinusB).apply(pMinusC); // (p-b)*(p-c)
        double underSquare = Operations.multiply.apply(pTimesPMinusA).apply(pMinusBTimesPMinusC); // p*(p-a)*(p-b)*(p-c)
        return Operations.squareRoot.apply(underSquare); // S = sqrt(p*(p-a)*(p-b)*(p-c))
    }
}
