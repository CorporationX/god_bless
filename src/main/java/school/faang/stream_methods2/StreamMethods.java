package school.faang.stream_methods2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class StreamMethods {

    public static Set<List<Integer>> findPairs(Set<Integer> numbers, int sum) {

        return numbers.stream()
                .filter(num -> num != sum - num && numbers.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    static List<String> sortCountries(Map<String, String> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();

    }

    static List<String> sortStringsByChar(List<String> list, char ch) {
        return list.stream()
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    static List<String> listToBinary(List<Integer> list) {
        return list.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    static List<String> filterStringsAlphabet(List<String> list, String alphabet) {

        String regex = "^[" + alphabet.toLowerCase() + "]+$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        return list.stream()
                .filter(Objects::nonNull)
                .filter(s -> !s.isEmpty() && pattern.matcher(s).matches())
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
