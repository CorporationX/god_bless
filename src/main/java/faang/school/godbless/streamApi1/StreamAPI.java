package faang.school.godbless.streamApi1;

import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5,6);
        System.out.println("Sum:" + sum(numbers));
        System.out.println("Max:" + max(numbers));
        System.out.println("Average:" + average(numbers));
    }

    public static int sum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    public static int max(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare).get();
    }

    public static double average(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.averagingInt(num->(int) num));
    }

    public static int numberOfStrings(List<String> text, char c){
        text.stream().filter(word->word.contains(c))
    }


}
