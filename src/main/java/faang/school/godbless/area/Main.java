package faang.school.godbless.area;

public class Main {
    public static void main(String[] args) {
        CountTriangleArea countTriangleArea = new CountTriangleArea();

        //6
        System.out.println(countTriangleArea.triangleArea(3, 4, 5));
        //30
        System.out.println(countTriangleArea.triangleArea(5, 12, 13));
        //null
        System.out.println(countTriangleArea.triangleArea(1, -5, 100));
        //null
        System.out.println(countTriangleArea.triangleArea(3, 2, 10));
    }
}
