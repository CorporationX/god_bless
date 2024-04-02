package faang.school.godbless.revert;


import static faang.school.godbless.revert.Example.reverse;

public class ExampleTest {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] reversedArray = reverse(array);
        for (int j : reversedArray) {
            System.out.println(j);
        }
    }
}
