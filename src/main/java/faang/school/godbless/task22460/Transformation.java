package faang.school.godbless.task22460;

import java.util.*;
import java.util.stream.Collectors;

public class Transformation {
    private Emploee emploee;
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
        return words.stream()
                .filter(word -> word.startsWith(String.valueOf(startsBy)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static Map<String, String> findMutualFriends(Map<String,List<String>> friendsMap){
        Map<String, String> result = new HashMap<>();
        return result;
    }

    public static Map<String, Integer> getAVGsalary(List<Emploee> listEmploee){
        return listEmploee.stream().collect(Collectors.groupingBy(Emploee::getDepartment,
                Collectors.averagingDouble(Emploee::getSalary));
    }
}
