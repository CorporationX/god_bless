package faang.school.godbless.revert;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();

        int[] array = new int[]{1, 2, 3, 4, 5};
        example.reverse(array);

        for (int num : array) {
            System.out.println(num);
        }
    }
}

