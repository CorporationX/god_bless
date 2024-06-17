package faang.school.godbless.streamAPI1;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StaticMethod {

    public static Integer honestSum(List<Integer> nums) {
        return nums.stream().filter(num -> num % 2 == 0).reduce(0, Integer::sum);
    }

    public static Integer maxNum(List<Integer> nums) {
        return nums.stream().mapToInt(v -> v).max().orElse(0);
    }

    public static double averageNum(List<Integer> nums) {
        return nums.stream().mapToDouble(i -> i).average().orElse(0);
    }

    public static Long countStr(List<String> str, String s) {
        return str.stream().filter(st -> st.startsWith(s)).count();
    }

    public static List<String> filterStr(List<String> str, String s) {
        return str.stream().filter(st -> st.contains(s)).toList();
    }

    public static List<String> sortForLenght(List<String> str) {
        return str.stream().sorted((s1, s2) -> s1.length() - s2.length()).toList();
    }

    public static Boolean anyMatchFind(List<String> str, Predicate predicate) {
        return str.stream().filter(st -> predicate.test(st)).findFirst().isPresent();
    }

    public static int minFind(List<Integer> nums, Integer element) {
        return nums.stream().filter(num -> num > element).sorted().findFirst().get();
    }

    public static List<Integer> strLenght(List<String> str) {
        return str.stream().map(s -> s.length()).toList();
    }

}
