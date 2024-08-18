package faang.school.godbless.task22460;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Transformation {
    public static List<Integer> getUniqueNumbersSum(List<Integer> listNumbers, Integer sum){
        List<Integer> result = new ArrayList<>();

        return result;
    }

    public static void getCapital(Map<String, String> mapCountries){
        mapCountries.values()
                .stream()
                .sorted()
                .forEach(System.out::println);
    }

    public static List<String> filterWordsByChar(List<String> words, char startsBy){
        List<String> result = words.stream()
                .filter(word -> word.startsWith(String.valueOf(startsBy)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        return result;
    }

    public static Map<String, String> findMutualFriends(Map<String,List<String>> friendsMap){
        Map<String, String> result = friendsMap.entrySet().stream().flatMap(name -> name.getValue().stream().)
        return result;
    }
}
