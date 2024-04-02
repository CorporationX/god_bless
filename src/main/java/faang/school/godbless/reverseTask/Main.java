package faang.school.godbless.reverseTask;

import java.util.Arrays;

import static faang.school.godbless.reverseTask.Example.reverse;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 5, 6};
        reverse(nums);

        Arrays.stream(nums).forEach(System.out::print);
    }
}
