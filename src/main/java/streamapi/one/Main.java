package streamapi.one;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static int getSumNumber(List<Integer> integerList) {
        checkList(integerList);

        return integerList.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int getMaxNumber(List<Integer> integerList) {
        checkList(integerList);

        return integerList.stream()
                .max(Comparator.naturalOrder()).orElse(0);
    }

    public static int getAverageNumber(List<Integer> integerList) {
        checkList(integerList);

        return (int) integerList.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(0);
    }

    public static long getLinesStartWithChar(List<String> stringList, char startChar) {
        checkList(stringList);

        return stringList.stream()
                .filter(str -> str.startsWith(String.valueOf(startChar))).count();
    }

    public static long getStringsWithSubstring(List<String> stringList, String substring) {
        checkList(stringList);

        return stringList.stream()
                .filter(str -> str.contains(substring)).count();
    }

    public static List<String> getFilterStringByLength(List<String> stringList, int length) {
        checkList(stringList);

        return stringList.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static <T> boolean isAllElementBeingChecked(List<T> list, Predicate<T> predicate) {
        checkList(list);

        return list.stream()
                .allMatch(predicate);
    }

    public static int getMinNumberAfterDefaultNumber(List<Integer> integerList, int defaultNumb) {
        checkList(integerList);

        return integerList.stream()
                .filter(num -> num > defaultNumb)
                .min(Comparator.naturalOrder()).orElse(defaultNumb);
    }

    public static List<Integer> getStringLength(List<String> stringList) {
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
