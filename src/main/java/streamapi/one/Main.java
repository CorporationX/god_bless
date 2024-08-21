package streamapi.one;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {


    public static int sumNumber(List<Integer> integerList) {
        checkList(integerList);

        return integerList.stream()
                .reduce(0, Integer::sum);
    }

    public static int maxNumber(List<Integer> integerList) {
        checkList(integerList);

        return integerList.stream()
                .max(Comparator.naturalOrder()).orElse(0);
    }

    public static int averageNumber(List<Integer> integerList) {
        checkList(integerList);

        return (int) integerList.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(0);
    }

    public static long linesStartWithChar(List<String> stringList, char startChar) {
        checkList(stringList);

        return stringList.stream()
                .filter(str -> str.startsWith(String.valueOf(startChar))).count();
    }

    public static long stringsWithSubstring(List<String> stringList, String substring) {
        checkList(stringList);

        return stringList.stream()
                .filter(str -> str.contains(substring)).count();
    }

    public static List<String> filterStringByLength(List<String> stringList, int length) {
        checkList(stringList);

        return stringList.stream()
                .filter(str -> str.length() > length)
                .collect(Collectors.toList());
    }

    public static boolean checkAllNumbersAreEven(List<Integer> integerList) {
        checkList(integerList);

        return integerList.stream()
                .allMatch(num -> num % 2 == 0);
    }

    public static int minNumberAfterDefaultNumber(List<Integer> integerList, int defaultNumb) {
        checkList(integerList);

        return integerList.stream()
                .filter(num -> num > defaultNumb)
                .min(Comparator.naturalOrder()).orElse(defaultNumb);
    }

    public static List<Integer> stringLength(List<String> stringList) {
        checkList(stringList);

        return stringList.stream()
                .map(String::length)
                .toList();
    }

    public static void checkList(List<?> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Список пуст");
        }
    }

}
