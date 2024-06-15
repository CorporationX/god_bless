package faang.school.godbless.practice_streamapi1;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> words = List.of("one", "two", "three", "four", "five", "six", "seven");
        String symbol = "f";
        String substring = "ve";
        String condition = "длина слова < 6";
        int givenNumber = 4;

        System.out.println("Сумма четных чисел в списке: " + sumEvenNumbers(numbers));
        System.out.println("Максимальное число в списке: " + maxNumber(numbers));
        System.out.println("Среднее значение чисел в списке: " + averageOfNumber(numbers));
        System.out.println("Количество строк, начинающихся с символа \"" + symbol + "\" в списке строк: "
                + countStringsStartWithSymbol(symbol, words));
        System.out.println("Строки, которые содержат подстроку \"" + substring + "\" : "
                + searchStringsContainSubstrings("ve", words).toString());
        System.out.println("Отсортированный список строк по длине: " + sortedStringsByLength(words));
        System.out.println("Удовлетворяют ли все элементы списка условию \"" + condition + "\": "
                + areStringsSatisfyTheCondition(words));
        System.out.println("Наименьший элемент в списке, который больше числа " + givenNumber + ": "
                + searchMinNumberThanMoreGivenNumber(numbers, givenNumber));
        System.out.println("Список длин, преобразованный из списка их строк: "
                + transformationStringsToStringsLengths(words));
    }

    public static int sumEvenNumbers(List<Integer> nums) {
        return nums.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int maxNumber(List<Integer> nums) {
        return nums.stream()
                .reduce(0, Integer::max);
    }

    public static int averageOfNumber(List<Integer> nums) {
        return (nums.stream()
                .reduce(0, Integer::sum)) / nums.size();
    }

    public static long countStringsStartWithSymbol(String symbol, List<String> words) {
        return words.stream()
                .filter(w -> w.startsWith(symbol))
                .count();
    }

    public static List<String> searchStringsContainSubstrings(String substring, List<String> words) {
        return words.stream()
                .filter(w -> w.contains(substring))
                .toList();
    }

    public static List<String> sortedStringsByLength(List<String> words) {
        return words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean areStringsSatisfyTheCondition(List<String> words) {
        return words.stream()
                .allMatch(word -> word.length() < 6);
    }


    public static int searchMinNumberThanMoreGivenNumber(List<Integer> nums, int givenNumber){
        return nums.stream()
                .filter(num -> num > givenNumber)
                .reduce(9, Integer::min);
    }

    public static List<Integer> transformationStringsToStringsLengths(List<String> words) {
        return words.stream()
                .map(String::length)
                .toList();
    }
}