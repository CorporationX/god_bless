package faang.school.godbless.Task_Train_API_1;

import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@NoArgsConstructor
public class Calculate {

    public static int findSum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, (sum, number) -> sum + number);
    }

    public static void findMax(List<Integer> numbers) {
        Optional<Integer> result = numbers.stream()
                .max(Comparator.comparingInt(x -> x));
        if (result.isPresent()) System.out.println(result.get());
        else System.out.println("something went wrong");
    }

    public static void findAvg(List<Integer> numbers) {
        if (numbers.isEmpty()) System.out.println("the list is empty");
        else {
            int res = numbers.stream()
                    .reduce(0, (sum, number) -> number + sum) / numbers.size();
            System.out.println(res);
        }
    }

    public static int findStrings(List<String> strings, char s) {
        if (strings.isEmpty()) return 0;
        else {
            return (int) strings.stream()
                    .filter(string -> string.startsWith(Character.toString(s)))
                    .count();
        }
    }

    public static void filterStrings(List<String> strings, String condition) {
        if (strings.isEmpty() || condition.isBlank()) System.out.println("invalid input");
        else {
            System.out.print("We found...");
            strings.stream()
                    .filter(string -> string.contains(condition))
                    .forEach(string -> System.out.print(string + " "));
        }
    }

    public static List<String> sortByLength(List<String> input) {
        return input.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean ifSuffice(List<Integer> elements, Predicate<Integer> predicate) {
        return elements.stream()
                .allMatch(predicate);
    }

    public static int findMinWithCondition(List<Integer> elements, Predicate<Integer> predicate) {
        List<Integer> yieldCondition = elements.stream()
                .filter(element -> predicate.test(element))
                .toList();
        Optional<Integer> minimum = yieldCondition.stream()
                .min(Comparator.comparingInt(x -> x));
        if (minimum.isPresent()) return minimum.get();
        else System.out.print("Something is wrong with input");
        return -1;
    }

    public static List<Integer> convertToLength(List<String> strings) {
        return strings.stream()
                .map(x->x.length())
                .toList();
    }

}
