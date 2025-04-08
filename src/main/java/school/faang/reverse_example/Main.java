package school.faang.reverse_example;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] numsEmpty = new int[]{};
        int[] numsOne = new int[]{1};
        int[] numsTwo = new int[]{1, 2};

        Example.reverse(nums);
        Example.reverse(numsEmpty);
        Example.reverse(numsOne);
        Example.reverse(numsTwo);

        log.info(Arrays.toString(nums));
        log.info(Arrays.toString(numsEmpty));
        log.info(Arrays.toString(numsOne));
        log.info(Arrays.toString(numsTwo));
    }
}
