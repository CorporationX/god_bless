package school.faang.task_47172;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static final String APPLE = "apple";
    public static final String BANANA = "banana";
    public static final String CHERRY = "cherry";
    public static final String DATE = "date";

    public static final String SUM_OF_EVEN_NUMBERS_MESSAGE = "Сумма четных чисел: ";
    public static final String FIND_MAX_MESSAGE = "Максимум: ";
    public static final String FIND_AVERAGE_MESSAGE = "Среднее: ";
    public static final String COUNT_STRINGS_STARTING_WITH_MESSAGE = "Количество строк, начинающихся на 'a': ";
    public static final String FILTER_STRINGS_MESSAGE = "Строки, содержащие 'an': ";
    public static final String SORT_BY_LENGTH_MESSAGE = "Отсортированные по длине строки: ";
    public static final String ALL_MATCH_CONDITION_MESSAGE = "Все ли числа чётные? ";
    public static final String FIND_MIN_GREATER_THAN_MESSAGE = "Наименьшее число больше 4: ";
    public static final String CONVERT_TO_LENGTHS_MESSAGE = "Длины строк: ";

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList(APPLE, BANANA, CHERRY, DATE);

        System.out.println(SUM_OF_EVEN_NUMBERS_MESSAGE + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println(FIND_MAX_MESSAGE + ListOperations.findMax(numbers));
        System.out.println(FIND_AVERAGE_MESSAGE + ListOperations.findAverage(numbers));
        System.out.println(COUNT_STRINGS_STARTING_WITH_MESSAGE + ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.println(FILTER_STRINGS_MESSAGE + ListOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.println(SORT_BY_LENGTH_MESSAGE + ListOperations.sortByLength(strings));
        System.out.println(ALL_MATCH_CONDITION_MESSAGE + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println(FIND_MIN_GREATER_THAN_MESSAGE + ListOperations.findMinGreaterThan(numbers, 4));
        System.out.println(CONVERT_TO_LENGTHS_MESSAGE + ListOperations.convertToLengths(strings));
    }
}