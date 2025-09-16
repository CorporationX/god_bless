package school.faang.bjs2_88163_streamAPI_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        var numbers = new ArrayList<>(Arrays.asList(0, 2, 5, null, 7, 6, 8));
        var words = Arrays.asList("apple", "banana", "apricot", "", null, "avocado", "grape", "Apple", "pineapple");

        Predicate<Integer> isEven = num -> num % 2 == 0;

        System.out.println("1. Сумма четных чисел:");
        System.out.println(StreamMethods.sumEvenNumbers(numbers));
        System.out.println("2. Максимальное значение:");
        System.out.println(StreamMethods.findMax(numbers));
        System.out.println("3. Среднее значение:");
        System.out.println(StreamMethods.countAverage(numbers));
        System.out.println("4. Количество строк начинающихся с «а»:");
        System.out.println(StreamMethods.countStringsStartingWith(words, 'a'));
        System.out.println("5. Строки которые содержат подстроку «ap»:");
        System.out.println(StreamMethods.filterBySubstring(words, "ap"));
        System.out.println("6. Сортируем строки по возрастанию их длины:");
        System.out.println(StreamMethods.sortStringByLong(words));
        System.out.println("7. Все числа в списке четные? -> " + StreamMethods.allMatch(numbers, isEven));
        System.out.println("8. Ищем наименьший элемент в списке больше 5");
        System.out.println(StreamMethods.findMinGreaterThan(numbers, 5));
        System.out.println("9. Преобразовываем строки в их длины");
        System.out.println(StreamMethods.mapToLength(words));
    }
}