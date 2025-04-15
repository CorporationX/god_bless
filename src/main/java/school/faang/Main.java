package school.faang;

import school.faang.remember_school.TriangleSquareCalculator;

public class Main {
    public static void main(String[] args) {
        Double square = TriangleSquareCalculator.calculateTriangleArea(3, 4, 5);
        try {
            TriangleSquareCalculator.calculateTriangleArea(3, 4, 45);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Площадь треугольника: " + square);
    }
}
