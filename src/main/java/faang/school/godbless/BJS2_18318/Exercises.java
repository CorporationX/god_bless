package faang.school.godbless.BJS2_18318;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercises {
    public static List<String> getSumOfNumbersThatEqualsToSpecific(List<Integer> numbers, int num) {
        return numbers.stream()
                .flatMap(number -> numbers.stream().filter(innerNumb -> number + innerNumb == num && number < innerNumb))
                .map(number -> number + " " + (num - number))
                .toList();
    }

    public static List<String> getSortedCapitals(Map<String, String> capitals) {
        return capitals
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();
    }

    public static List getSortedStringStartedWithSpecificSymbol(List<String> strings, char symbol) {
        return strings
                .stream()
                .filter(str -> str.charAt(0) == symbol)
                .sorted(Comparator.comparingInt(String::length))
                .toList();

    }

    public static List getPeopleWhoDontKnowEachOther(Map<String, List<String>> friendsByPerson) {
        return friendsByPerson
                .entrySet()
                .stream()
                .flatMap(pair -> friendsByPerson
                        .entrySet()
                        .stream()
                        .filter(pair2 -> !pair2.getKey().equals(pair.getKey()))
                        .filter(pair2 -> !pair2.getValue().contains(pair.getKey()))
                        .filter(pair2 -> pair2.getValue().stream().anyMatch(par2 -> pair.getValue().contains(par2)))
                        .map(resultPairs -> createOrderedPerson(pair.getKey(), resultPairs.getKey())))
                .distinct()
                .toList();
    }

    private static String createOrderedPerson(String person1, String person2) {
        return person1.compareTo(person2) < 0 ? person1 + " " + person2 : person2 + " " + person1;
    }

    public static Map<String, Double> findAvgSalaryByDepartment(List<Employee> employees) {
        return employees
                .stream()
                .collect(Collectors
                        .groupingBy(Employee::department,
                                Collectors.averagingDouble(Employee::salary)));
    }

    public static List sortBySpecifiedChars(List<String> strings, String alphabet) {
        return strings
                .stream()
                .filter(str -> Arrays.stream(str.split("")).allMatch(alphabet::contains))
                .toList();
    }

    public static List convertNumbersToCode(List<Integer> numbers) {
        return numbers
                .stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List findPalindromes(int startNumber, int finalNumber) {
        return IntStream.rangeClosed(startNumber, finalNumber).filter(num -> num == getReversedNumber(num)).boxed().toList();
    }

    private static int getReversedNumber(int num) {
        int rev_num = 0;
        while (num > 0) {
            rev_num = rev_num * 10 + num % 10;
            num = num / 10;
        }
        return rev_num;
    }

    public static List findPalindromesFromString(String word) {
        return IntStream
                .range(0, word.length())
                .boxed()
                .flatMap(index -> IntStream
                        .rangeClosed(index + 1, word.length())
                        .filter(endIndex -> isPalindrome(word, index, endIndex))
                        .mapToObj(endIndex -> word.substring(index, endIndex))).toList();
    }

    private static boolean isPalindrome(String word, int start, int end) {
        String currentWord = word.substring(start, end);
        return currentWord.contentEquals(new StringBuffer(currentWord).reverse());
    }
}
