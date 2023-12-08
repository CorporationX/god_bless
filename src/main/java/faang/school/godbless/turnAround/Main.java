package faang.school.godbless.turnAround;

public class Main {
    public static void main(String[] args) {
        int[] numbers = Example.reverse(new int[]{1, 2, 3, 4, 5, 6, 7});
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(" " + numbers[i]);
        }
    }
}
