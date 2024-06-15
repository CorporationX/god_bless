package faang.school.godbless.streamAPI2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrenStreamAPI {
    public static void main(String[] args) {
//        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 23);
//        searchSumPairTarget(list, 14).forEach(System.out::println);

//        Map<String, String> map = Map.of(
//                "c", "asd",
//                "b", "tr",
//                "a", "lk",
//                "d", "py"
//        );
//        sortCapitalByCountry(map).forEach(System.out::println);

//        List<String> list = List.of("asdfg", "aghjh", "agfjhkjh", "wey", "yhgdf", "etjyh", "rtyh");
//        findByCharAndSort(list, 'a').forEach(System.out::println);

        Map<String, List<String>> map = new HashMap<>();
        List<String> list1 = List.of("1", "2", "3", "4");
        List<String> list2 = List.of("5", "6", "7", "8");
        List<String> list3 = List.of("9", "10", "11", "12");
        List<String> list4 = List.of("1", "0", "0", "0");
        List<String> list5 = List.of("2", "9", "6", "2");
        List<String> list6 = List.of("6", "12", "13", "14");
        map.put("1", list1);
        map.put("2", list2);
        map.put("3", list3);
        map.put("4", list4);
        map.put("5", list5);
        map.put("6", list6);
        method(map).forEach(System.out::println);
    }

//    public static Set<List<Integer>> searchSumPairTarget(List<Integer> numbers, int target) {
//        return numbers.stream()
//                .flatMap(i -> numbers.stream()
//                        .filter(j -> i + j == target)
//                        .map(j -> Arrays.asList(i, j)))
//                .filter(pair -> pair.get(1) < pair.get(0))
//                .collect(Collectors.toSet());
//
//    }

//    public static List<String> sortCapitalByCountry(Map<String, String> country) {
//        return country.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByKey())
//                .map(Map.Entry::getValue)
//                .toList();
//    }

//    public static List<String> findByCharAndSort(List<String> list, char target) {
//        return list.stream()
//                .filter(s -> s.charAt(0) == target)
//                .sorted((o, t) -> o.length() - t.length())
//                .toList();
//    }

//    public static Set<List<String>> method(Map<String, List<String>> map) {
//        return map.keySet().stream()
//                .flatMap(pers1 -> map.keySet().stream()
//                        .filter(pers2 -> !pers1.equals(pers2)
//                                && !map.get(pers1).contains(pers2)
//                                && !map.get(pers2).contains(pers1))
//                        .map(pers2 -> {
//                            List<String> pair = Arrays.asList(pers1, pers2);
//                            Collections.sort(pair);
//                            return pair;
//                        }))
//                .filter(pair -> {
//                    var friendOfPers1 = new HashSet<>(map.get(pair.get(0)));
//                    var friendOfPers2 = new HashSet<>(map.get(pair.get(1)));
//                    return friendOfPers1.retainAll(friendOfPers2);
//                })
//                .collect(Collectors.toSet());
//    }

    public static Map<String, Integer> middleSalaryForDepartment(List<Employee> employees) {

    }
}
