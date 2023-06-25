package faang.school.godbless.streamAPI.part1;

import java.util.List;

public class StreamApiFunctions {
    public static Integer getEvenSum(List<Integer> integerList) {
        if (integerList == null) {
            return null;
        }
        return integerList.stream().filter(n -> n % 2 == 0).reduce(0, Integer::sum);
    }

    public static Integer getMaxValue(List<Integer> integerList) {
        if (integerList == null) {
            return null;
        }
        return integerList.stream().reduce(Integer::max).get();
    }

    public static Double getMeanValue(List<Integer> integerList) {
        if (integerList == null) {
            return null;
        }
        return integerList.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }

    public static int getCountStrings(List<String> stringList, String charStart) {
        if (stringList == null) {
            return 0;
        }
        return (int) stringList.stream().filter(str -> str.toLowerCase().startsWith(charStart.toLowerCase()))
                .count();
    }

    public static List<String> filterStrings(List<String> stringList, String subString) {
        if (stringList == null) {
            return null;
        }
        return stringList.stream().filter(str -> str.toLowerCase().contains(subString.toLowerCase()))
                .toList();
    }
}
