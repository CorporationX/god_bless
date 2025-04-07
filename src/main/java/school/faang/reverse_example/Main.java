package school.faang.reverse_example;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        List<Integer> numsEmpty = new ArrayList<>(List.of());
        List<Integer> numsOne = new ArrayList<>(List.of(1));
        List<Integer> numsTwo = new ArrayList<>(List.of(1, 2));

        Example.reverse(nums);
        Example.reverse(numsEmpty);
        Example.reverse(numsOne);
        Example.reverse(numsTwo);

        log.info(nums.toString());
        log.info(numsEmpty.toString());
        log.info(numsOne.toString());
        log.info(numsTwo.toString());
    }
}
