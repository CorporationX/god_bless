package streamApi.task2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApi2 {
    public static void findPair(List<Integer> numbers, int target){
        List<List<Integer>> collect = numbers.stream()
                .flatMap(num1 -> numbers.stream()
                        .filter(num2 -> num1 + num2 == target && num1 != num2)
                        .map(num2 -> Arrays.asList(num1, num2)
                                .stream()
                                .sorted()
                                .collect(Collectors.toList())))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void printCountryCity(Map<String, String> countries){
        countries.entrySet().stream()
                .sorted((country1, country2) -> country1.getKey().compareTo(country2.getKey()))
                .forEach(city-> System.out.println(city.getValue()));
    }
    public static List<String> getList(List<String> strings, char symbol){
        List<String> list = strings.stream()
                .filter(string -> string.startsWith(String.valueOf(symbol)))
                .sorted((str1, str2) -> str1.length() - str2.length())
                .collect(Collectors.toList());
        return list;
    }
    public static void pairFriends(Map<String, List<String>> listFriends){
        listFriends.entrySet().stream()
                .forEach(friends -> listFriends.entrySet()
                        .stream().filter(friendsList -> friends.getValue().contains(friendsList.getValue()))
                        .map(friends2 -> Arrays.asList(friends.getKey(),friends2.getKey())
                                .stream()
                                .collect(Collectors.toList())).distinct().collect(Collectors.toList()));
    }
}
