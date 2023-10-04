package faang.school.godbless.javamagics.set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 2, 4, 5, 3, 6, 7, 5);

    }

    public static Set<Integer> usingForLoop(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.size(); i++) {
            set.add(numbers.get(i));
        }

        return set;
    }

    public static Set<Integer> usingForEachLoop(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();

        for (Integer number : numbers) {
            set.add(number);
        }

        return set;
    }

    public static Set<Integer> usingAddAll(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        set.addAll(numbers);

        return set;
    }

    public static Set<Integer> usingConstructor(List<Integer> numbers) {
        return new HashSet<>(numbers);
    }
}
