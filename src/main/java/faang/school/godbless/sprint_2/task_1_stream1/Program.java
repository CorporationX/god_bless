package faang.school.godbless.sprint_2.task_1_stream1;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(8, 1, 6, 3, 5, 7, 9, 2, 10, 4);
        System.out.println("список: " + numbers);

        Optional<Integer> sumEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce((s, n) -> s + n);
        System.out.println("Сумма чётных чисел: " + sumEvenNumbers.orElse(0));

        Optional<Integer> maxNumber = numbers.stream().max((a, b) -> a - b);
        System.out.println("Наибольшее число: " + maxNumber.get());

        int count = numbers.size();
        Integer sum = numbers.stream().reduce(Integer::sum).orElse(0);
        if (sum != 0) {
            double average = ((double) sum / count);
            System.out.println("Наибольшее число: " + average);
        }

        List<String> strings = List.of("Молитва", "Осень", "Пёс", "Валет", "Балаган", "Бобслей", "Будка", "Вино");
        System.out.println("Список слов: " + strings);

        char chB = 'б';
        char chV = 'в';
        int countB = (int) strings.stream()
                .filter(s -> s.charAt(0) == chB)
                .count();
        System.out.printf("Количество слов начинающихся с символа %s: %d\n", chB, countB);

        int countV = (int) strings.stream()
                .filter(s -> s.toLowerCase().charAt(0) == chV)
                .count();
        System.out.printf("Количество слов начинающихся с символа %s: %d\n", chV, countV);

        String subString = "ле";
        System.out.printf("Слова содержащие подстроку \"%s\": \n", subString);
        strings.stream()
                .filter(s -> s.toLowerCase().contains(subString))
                .forEach(System.out::println);

        List<String> sortString = strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("Список слов отсортированный по длинне: " + sortString);

        int conditionLength = 3;
        boolean answer = strings.stream().allMatch(s -> s.length() >= conditionLength);
        System.out.printf("Все слова в списке длиннее %d: %s\n", conditionLength, answer);

        int minLength = 4;
        String firstElement = strings.stream()
                .filter(s -> s.length() > minLength)
                .min(Comparator.comparing(String::length)).orElse("подходящего слова нет");
        System.out.printf("Наименьшее слово длинее %d: %s\n", minLength, firstElement);

        List<Integer> lengthList = strings.stream().map(String::length).toList();
        System.out.printf("Список строк: %s\n", strings);
        System.out.printf("Список длин: %s\n", lengthList);
    }
}
