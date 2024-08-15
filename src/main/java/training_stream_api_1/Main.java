package training_stream_api_1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        List<String> strings = List.of("sseye", "eye","sswoke");

        List<Integer> emptyIntsList = List.of();
        List<String> emptyStringList = List.of();

        System.out.println("Сумма четных: " + StreamApiTrainer.getSumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + StreamApiTrainer.getMax(numbers));
        System.out.println("Среднее: " + StreamApiTrainer.getAverage(numbers));
        System.out.println("Начинается с 'ss': " +
                StreamApiTrainer.getStringsStartsWith(strings, "ss"));

        System.out.println("Содержит 'eye'" +
                StreamApiTrainer.filterBySubstring(strings, "eye"));

        System.out.println("Отсортированы по длине: " + StreamApiTrainer.sortByLength(strings));

        System.out.println("Являются ли все нечетными: " +
                StreamApiTrainer.isAllMatch(numbers, x -> x % 2 != 0));

        System.out.println("Наименьший элемент больше 4: " +
                StreamApiTrainer.getSmallestGreaterThen(numbers, 4));

        System.out.println("Длины строк: " + StreamApiTrainer.mapToLengths(strings));
    }
}
