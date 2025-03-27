package school.faang.practice_stream_api_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Operations {
    public static List<List<Integer>> findUniquePairsWithSpecificSum1(List<Integer> nums, int target) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> notForUse = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        return nums.stream()
                .forEach(num -> {
                    if (notForUse.contains(num)) {
                        return;
                    } else {
                        for (int numm : seen) {
                            if (numm + num == target) {
                                result.add(Arrays.asList(num, numm));
                                notForUse.add(num);
                                notForUse.add(numm);
                            }
                        }
                    }
                })
        как в джаве иметь ключом пару - чтобы пары не повторялись
    }
}
