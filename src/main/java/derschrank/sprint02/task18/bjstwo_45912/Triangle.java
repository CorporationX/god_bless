package derschrank.sprint02.task18.bjstwo_45912;

public record Triangle(
    double a,
    double b,
    double c
) {
    public Triangle(double a, double b, double c) {
        checkTriangleIsValid(a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private void checkTriangleIsValid(double a, double b, double c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Sizes of Triangle is incorrect");
        }
    }
}
