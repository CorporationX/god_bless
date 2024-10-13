package school.faang.streamapitwo;

import java.util.*;

public class StreamProcessor {

    public static void twoSum(List<Integer> nums, int target){
        Map<Integer, Boolean> map = new HashMap<>();

        List<int[]> result = nums.stream()
                .filter(num -> {
                    int complement = target - num;
                    if (Boolean.TRUE.equals(map.getOrDefault(complement, false))) {
                        return true;
                    }
                    map.put(num, true);
                    return false;
                })
                .map(num -> new int[]{target - num, num})
                .toList();

        result.forEach(pair -> System.out.println(Arrays.toString(pair)));
    }

    public static List<String> sortByAlphabet(Map<String, String> data){
        return data.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();
    }

    public static List<String> sortStrings(List<String> strings, char symbol){
        return strings.stream()
                .filter(string -> string.charAt(0) == symbol).sorted().toList();
    }

    public static List<String> convertToBinaryString(List<Integer> nums){
        return nums.stream()
                .map(Integer::toBinaryString).toList();
    }

    public static List<String> sortString(List<String> strings, String alphabet){
        return strings.stream()
                .filter(s -> s.chars().allMatch(str -> alphabet.indexOf(str) >= 0))
                .sorted()
                .toList();
    }
}
