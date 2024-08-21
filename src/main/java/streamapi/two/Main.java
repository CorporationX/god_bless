package streamapi.two;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static List<List<Integer>> findPairNumb(List<Integer> integerList, int targetSum) {

        Map<Integer, Integer> numberIndexMap = IntStream.range(0, integerList.size()).boxed()
                .collect(Collectors.toMap(integerList::get,
                        s -> s));

        return integerList.stream()
                .filter(s -> numberIndexMap.containsKey(targetSum - s))
                .filter(num -> integerList.indexOf(num) < numberIndexMap.get(targetSum - num))
                .map(j -> List.of(j, targetSum - j))
                .collect(Collectors.toList());
    }

    public static List<String> getSortedListOfCapitals(Map<String, String> capitalsMap) {
        return capitalsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortString(List<String> stringList, char letter) {

        return stringList.stream()
                .filter(str -> str.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortStrings(List<String> stringList, char[] alphabet) {

        String alphabetSet = new String(alphabet);

        String regex = "^[" + Pattern.quote(alphabetSet) + "]+$";
        Pattern pattern = Pattern.compile(regex);

        return stringList.stream()
                .filter(str -> pattern.matcher(str).matches())
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertIntToBinaryString(List<Integer> integerList) {
        return integerList.stream().map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }
}
