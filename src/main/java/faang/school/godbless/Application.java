package faang.school.godbless;

public class Application {
    public static void main(String... args) {
        System.out.println("Hello world");
        int[] numbers = {1,2,3,4,5,6,7,8,9,0};
        int[] reversNum = Example.reverse(numbers);
        for (int j : reversNum) {
            System.out.print(j);
        }
    }
}
