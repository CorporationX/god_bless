package streamApi.task1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int evenSum = Stream.evenSum(numbers);
        System.out.println(evenSum);
        int max = Stream.max(numbers);
        System.out.println(max);
        double average = Stream.average(numbers);
        System.out.println(average);
        List<String> strings = List.of("str", "chelsea", "stringsss");
        long countString = Stream.countString('s', strings);
        System.out.println(countString);
        List<String> substringList = Stream.getSubstringList("ing", strings);
        System.out.println(substringList);
        Stream.sortedList(strings);
        boolean checkElement = Stream.anyMatch(strings);
        System.out.println(checkElement);
        int min = Stream.specialMin(3, numbers);
        System.out.println(min);
        List<Integer> sheetLenghts = Stream.transformer(strings);
        System.out.println(sheetLenghts);
    }
}
