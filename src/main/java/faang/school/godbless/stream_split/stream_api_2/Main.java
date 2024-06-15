package faang.school.godbless.stream_split.stream_api_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static Set<Pair<Integer>> uniquePair(List<Integer> nums, int target) {

//        Set<Integer> setNum = new HashSet<>(nums);
//        Set<Pair> pairs = new HashSet<>();
//
//        nums.forEach(n -> {
//            if (setNum.contains(target - n)) {
//                pairs.add(new Pair(n, target - n));
//            }
//        });
//
//        return pairs;

        return nums.stream().filter(n -> nums.stream().anyMatch(num -> (n + num == target && !n.equals(num))))
                .map(n -> new Pair<>(n, target - n).sort())
                .collect(Collectors.toSet());

    }

    public static List<String> sortCountry(Map<String, String> country) {
        List<String> cap = country.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).toList();

        return cap;
    }

    public static List<String> sortStrings(List<String> srs, char letter) {

        return srs.stream().filter(s -> s.charAt(0) == letter).sorted().toList();
    }

    public static Set<Pair<String>> getListFriend(Map<String, List<String>> users) {

        return users.entrySet().stream()
                .flatMap(u1 -> users.entrySet().stream()
                        .filter(u2 -> !u2.equals(u1))
                        .filter(u2 -> !u1.getValue().contains(u2.getKey()))
                        .filter(u2 -> {
                            Set<String> set = new HashSet<>(u2.getValue());
                            set.retainAll(u1.getValue());
                            return !set.isEmpty();
                        }).map(u2 -> new Pair<>(u1.getKey(), u2.getKey()).sort())
                ).collect(Collectors.toSet());

    }



//    public static Map<String, Integer> averageSalaryDep(List<Employee> workers) {
//        Map<String, Integer> averageSal = new HashMap<>();
//
//        workers.stream().filter(w -> {
//            if (averageSal.get(w.))
//        })
//    }

    public static void main(String[] args) {
        System.out.println(uniquePair(List.of(1, 9, 3, 6, 4, 5), 10)); // (1,9) (4,6)

        Map<String, String> countries = Map.of("Russia","Moscow","Kazakstan","Astana","Japan","Tokio");

        System.out.println(sortCountry(countries));

        List<String> srs = List.of("gad", "dslf", "a", "afdgl", "dsf", "ad");

        System.out.println(sortStrings(srs, 'a'));

        Map<String, List<String>> userToFriendsMap = Map.of(
                "User 1", List.of(),
                "User 2", List.of("User 3"),
                "User 3", List.of("User 2", "User 4", "User 5"),
                "User 4", List.of("User 3", "User 5"),
                "User 5", List.of("User 3", "User 4"));

        System.out.println(getListFriend(userToFriendsMap));

        Pair2 p1 = new Pair2("User 2","User 4");
        Pair2 p2 = new Pair2("User 4","User 2");
        System.out.println(p1.equals(p2));



    }
}
