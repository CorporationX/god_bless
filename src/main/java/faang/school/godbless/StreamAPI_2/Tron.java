package faang.school.godbless.StreamAPI_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Tron {

    private final List<Integer> list = List.of(2, 3, 7, 4);

    private final int num = 5;

    protected static void getUniquePairsOfNumbers(List<Integer> list, int num) {
        Set<Integer> set = list.stream().collect(Collectors.toSet());
        Set<int[]> arrSet = new HashSet<>();
        int nums;
        for (Integer integer : set) {
            nums = integer;
            int[] ints = new int[2];
            ints[0] = nums;
            if (ints[0] != 0 && ints[1] != 0) {
                arrSet.add(ints);
            }
        }
    }
}
