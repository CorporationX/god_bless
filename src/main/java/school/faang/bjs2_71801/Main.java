package school.faang.bjs2_71801;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("44444", "34253", "444");
        System.out.println(Operations.containString(list, "4444"));
        System.out.println(Operations.sortByLength(list));
    }

    public static class Operations {
        public static int evenSum(List<Integer> numbers) {
            return numbers.stream().filter(a -> a % 2 == 0).reduce(Integer::sum).orElseThrow();
        }

        public static int max(List<Integer> numbers) {
            return numbers.stream().max(Comparator.naturalOrder()).orElseThrow();
        }

        public static double average(List<Integer> numbers) {
            return (double) numbers.stream().reduce(Integer::sum).orElseThrow() / numbers.size();
        }

        public static long startsWithLetter(List<String> strings, char firstLetter) {
            return strings.stream().filter(s -> s.startsWith(String.valueOf(firstLetter))).toArray().length;
        }

        public static List<String> containString(List<String> strings, String subString) {
            return strings.stream().filter(s -> s.contains(subString)).toList();
        }

        public static List<String> sortByLength(List<String> strings) {
            return strings.stream().sorted(Comparator.comparingInt(String::length).reversed()).toList();
        }
    }
}
