package faang.school.godbless.javaCore.reverseTask;

import java.util.Arrays;

import static faang.school.godbless.javaCore.reverseTask.Example.reverse;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 5, 6};
        int[] reversedNums = reverse(nums);

        Arrays.stream(nums).forEach(System.out::print);

        System.out.println();

        Arrays.stream(reversedNums).forEach(System.out::print);
    }
}
