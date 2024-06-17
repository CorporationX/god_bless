package faang.school.godbless.streamAPI2;

import java.util.*;

public class StaticMethod {
    public static List<List<Integer>> pairChisel(List<Integer> nums, Integer element) {
        Set<Integer> result = new HashSet<>();
        List<List<Integer>> pairs = new ArrayList<>();
        nums.stream().distinct().forEach(num -> {
            Integer target = element - num;
            result.add(num);
            if(nums.contains(target) && !result.contains(target)) {
                result.add(target);
                pairs.add(List.of(target, num));
            }
        });
        return pairs;
    }

    public static List<String> cityList(HashMap<String, String> cityCapital) {
        List<String> result = new ArrayList<>();

        return result;
    }
}
