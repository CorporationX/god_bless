package faang.school.godbless.task27;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int target = 10;

        Set<Map<Integer, Integer>> pairs = findPairs(nums, target);
        System.out.println(pairs);
        Map<String, String> countryCapitals = new HashMap<>();
        countryCapitals.put("France", "Paris");
        countryCapitals.put("Germany", "Berlin");
        countryCapitals.put("Italy", "Pome");
        countryCapitals.put("Spain", "Madrid");
        countryCapitals.put("Japan", "Tokyo");
        sortCountriesAndPrintCapitals(countryCapitals);

        System.out.println(sortCountriesAndPrintCapitals(countryCapitals.values().stream().toList(),'P'));

        Map<String, List<String>> friendsMap = new HashMap<>();
        friendsMap.put("Alice", Arrays.asList("Bob", "Charlie", "David"));
        friendsMap.put("Bob", Arrays.asList("Alice", "Charlie"));
        friendsMap.put("Charlie", Arrays.asList("Alice", "Bob", "David"));
        friendsMap.put("David", Arrays.asList("Alice", "Charlie"));
        friendsMap.put("Eve", List.of("Frank"));
        friendsMap.put("Frank", List.of("Eve"));
        System.out.println(findSubFriends(friendsMap));
    }
    public static Set<Map<Integer, Integer>> findPairs(List<Integer> integerList, int key) {
        return integerList.stream().flatMap(x -> integerList.stream().filter((y) -> x + y == key)
                .map(y -> {
                    Map<Integer, Integer> map = new HashMap<>();
                    map.put(x, y);
                    return map;
                })).collect(Collectors.toSet());
    }
    public static void sortCountriesAndPrintCapitals(Map<String,String> countries) {
            countries.entrySet().stream().sorted((x,y)->y.getValue().compareTo(x.getValue())).map(Map.Entry::getValue).forEach(System.out::println);
    }
    public static List<String> sortCountriesAndPrintCapitals(List<String> strings, char letter) {
       return strings.stream().filter(s->s.startsWith(String.valueOf(letter))).sorted(Comparator.comparingInt(String::length)).toList();
    }
    public static List<Map<String,String>> findSubFriends(Map<String,List<String>> friendsList) {
       return friendsList.entrySet().stream().flatMap(x->friendsList.entrySet().stream()
               .filter(v->!v.getValue().contains(x.getKey())&&v.getValue().stream().anyMatch(y->x.getValue().contains(y)))
               .map(y->{
                       Map<String,String> map = new HashMap<>();
                       map.put(x.getKey(), y.getKey());
                       return map;
               }).filter())
               .toList();
    }
}
