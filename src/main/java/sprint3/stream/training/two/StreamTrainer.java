package sprint3.stream.training.two;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StreamTrainer {
    public static Set<Pair> findPairNumbers(List<Integer> nums, int sum) {
        Set<Pair> result = new HashSet<>();
        int wrongNum = sum + 1;
        List<Integer> filtredList = nums.stream()
                .filter(num -> num <= sum)
                .toList();

        for (int i = 0; i < filtredList.size(); i++) {
            int foundSum = findSum(filtredList, sum, i);
            if (foundSum != wrongNum) {
                result.add(new Pair(filtredList.get(i), foundSum));
            }
        }
        return result;
    }

    public static void sortStringMapAndPrint(Map<String, String> countries) {
        countries.entrySet().stream()
                .sorted()
                .map(Map.Entry::getValue)
                .forEach(System.out::println);
    }

    private static int findSum(List<Integer> nums, int sum, int listElement) {
        int wrongNum = sum + 1;
        return nums.stream()
                .takeWhile(num -> nums.get(listElement) + num == sum)
                .findFirst()
                .orElse(wrongNum);
    }

    record Pair(int first, int second) {
    }
}
