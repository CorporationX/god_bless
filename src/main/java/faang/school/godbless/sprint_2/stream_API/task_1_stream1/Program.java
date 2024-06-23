package faang.school.godbless.sprint_2.stream_API.task_1_stream1;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Program {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(8, 1, 6, 3, 5, 7, 9, 2, 10, 4);
        System.out.println("список: " + numbers);

        Optional<Integer> sumEvenNumbers = calcSumEvenNumbers(numbers);
        System.out.println("Сумма чётных чисел: " + sumEvenNumbers.orElse(0));

        Optional<Integer> maxNumber = numbers.stream().max(Comparator.comparingInt(a -> a));
        System.out.println("Наибольшее число: " + maxNumber.get());

        double average = numbers.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
        System.out.println("Среднее арифметическое: " + average);

        List<String> strings = List.of("Молитва", "Осень", "Пёс", "Валет", "Балаган", "Бобслей", "Будка", "Вино");
        System.out.println("Список слов: " + strings);

        char ch = 'б';
        int count = calcCountWordFirstChar(strings, ch);
        System.out.printf("Количество слов начинающихся с символа %s: %d\n", ch, count);

        String subString = "ле";
        List<String> wordsWithSubstring = findWordsWithSubstring(strings, subString);
        System.out.printf("Слова содержащие подстроку \"%s\": %s\n", subString, wordsWithSubstring);

        List<String> sortString = sortByLength(strings);
        System.out.println("Список слов отсортированный по длинне: " + sortString);

        int conditionLength = 3;
        boolean answer = strings.stream().allMatch(s -> s.length() >= conditionLength);
        System.out.printf("Все слова в списке длиннее %d: %s\n", conditionLength, answer);

        int minLength = 4;
        String shortWord = findShortWordByCondition(strings, minLength);
        System.out.printf("Наименьшее слово длинее %d: %s\n", minLength, shortWord);

        List<Integer> lengthList = strings.stream().map(String::length).toList();
        System.out.printf("Список строк: %s\n", strings);
        System.out.printf("Список длин: %s\n", lengthList);
    }

    private static String findShortWordByCondition(List<String> strings, int minLength) {
        return strings.stream()
                .filter(s -> s.length() > minLength)
                .min(Comparator.comparing(String::length)).orElse("подходящего слова нет");
    }

    private static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static List<String> findWordsWithSubstring(List<String> strings, String subString) {
        return strings.stream()
                .filter(s -> s.toLowerCase().contains(subString))
                .toList();
    }

    private static int calcCountWordFirstChar(List<String> strings, char ch) {
        String chStr = String.valueOf(ch);
        return (int) strings.stream()
                .filter(s -> String.valueOf(s.charAt(0)).equalsIgnoreCase(chStr))
                .count();
    }

    private static Optional<Integer> calcSumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(Integer::sum);
    }
}
