package streamApiTwo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Main main = new Main();
        main.uniquePairsOfNumbers(numbers, 7);
        main.convertNumbersToBinary(numbers);
    }

    public void uniquePairsOfNumbers(List<Integer> numbers, int k) {
        Set<Integer> checkedNumbers = new HashSet<>();
        Set<int[]> pairs = new HashSet<>();

        numbers.stream()
                .filter(number -> checkedNumbers.add(number))
                .flatMap(number -> numbers.stream().map(number2 -> new int[]{number, number2}))
                .filter(pair -> pair[0] + pair[1] == k)
                .forEach(pair -> pairs.add(pair));

        pairs.forEach(pair -> System.out.println(Arrays.toString(pair)));
    }

    public void convertNumbersToBinary(List<Integer> numbers) {
        numbers.stream()
                .map(Integer::toBinaryString)
                .forEach(System.out::println);
    }
}
