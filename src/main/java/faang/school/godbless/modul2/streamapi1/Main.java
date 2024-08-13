package faang.school.godbless.modul2.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numsList = List.of(1, 2, 3, 4, 5);

        System.out.println("1. Even nums sum: " + getEvenNumSum(numsList));
        System.out.println("2. Max number: " + getMaxNum(numsList));
        System.out.println("3. Average number: " + getAverageNum(numsList));
        System.out.println("7. Check all elements for certain condition: " + getCheckElements(numsList, x -> x < 9));
        System.out.println("8. Min num which more than specific num: " + getFindMinNumFromSpecificNum(numsList, 3));

        System.out.println();

        List<String> strList = List.of("Alfa", "Bravo", "Bradley", "Charlie", "Delta", "Echo");

        System.out.println("4. String count from specific char: " + getStringCount(strList, 'B'));
        System.out.println("5. Filter strings from specific substring : " + getFilterStrings(strList, "Br"));
        System.out.println("6. Sort list by length: " + getSortByLength(strList));
        System.out.println("7. Check all elements for certain condition: " + getCheckElements(strList, x -> x.length() < 20));
        System.out.println("9. Convert strings to length: " + getConvertStringsToLengths(strList));
    }

    public static int getEvenNumSum(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static OptionalInt getMaxNum(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .max();
    }

    public static OptionalDouble getAverageNum(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .average();
    }

    public static long getStringCount(List<String> stringList, char symbol) {
        return stringList.stream()
                .filter(str -> str.startsWith(String.valueOf(symbol)))
                .count();
    }

    public static List<String> getFilterStrings(List<String> stringList, String substring) {
        return stringList.stream()
                .filter(str -> str.contains(substring))
                .toList();
    }

    public static List<String> getSortByLength(List<String> stringList) {
        return stringList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static <T> boolean getCheckElements(List<T> list, Predicate<T> predicate) {
        return list.stream().allMatch(predicate);
    }

    public static OptionalInt getFindMinNumFromSpecificNum(List<Integer> nums, int specificNum) {
        return nums.stream()
                .filter(num -> num > specificNum)
                .mapToInt(Integer::intValue)
                .min();
    }

    public static List<Integer> getConvertStringsToLengths(List<String> stringList) {
        return stringList.stream()
                .map(String::length)
                .toList();
    }
}
