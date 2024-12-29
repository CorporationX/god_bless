package practice_streamAPI_1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class NumberChanger {

    public int addingListNumbers(List<Integer> integerList) {
        return integerList.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public int searchMaxNumber(List<Integer> integerList) {
        return integerList.stream()
                .max(Integer::compare)
                .orElse(-1);
    }

    public double calculatingAverageNumber(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public int countInitialChar(char symbol, List<String> stringList) {
        return (int) stringList.stream()
                .filter(NumberChanger::isNullOrBlank)
                .map(string -> string.toUpperCase().charAt(0))
                .filter(character -> character.equals(Character.toUpperCase(symbol)))
                .count();
    }

    public List<String> filtersList(List<String> stringList, String string) {
        Pattern pattern = Pattern.compile(string, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        return stringList.stream()
                .filter(NumberChanger::isNullOrBlank)
                .filter(pattern.asPredicate())
                .toList();
    }

    public List<String> sortLengthStrings(List<String> stringList) {
        return stringList.stream()
                .filter(NumberChanger::isNullOrBlank)
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public boolean checkListIntegerCondition(List<Integer> integerList, Predicate<Integer> predicate) {
        return integerList.stream()
                .allMatch(predicate);
    }

    public int findMinGreaterThan(List<Integer> integerList, int number) {
        return integerList.stream()
                .filter(num -> num > number)
                .min(Integer::compare)
                .orElse(number);
    }
    public List<Integer> convertToLengths (List<String> stringList){
        return stringList.stream()
                .filter(NumberChanger::isNullOrBlank)
                .map(String::length)
                .toList();
    }

    private static boolean isNullOrBlank(String string) {
        return string != null && !string.isBlank();
    }
}