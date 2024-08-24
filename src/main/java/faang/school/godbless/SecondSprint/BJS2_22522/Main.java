package faang.school.godbless.SecondSprint.BJS2_22522;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 9, 3, 6, 4, 4, 5, 5);


        Map<Integer, List<Integer>> map = integers.stream()
                .distinct()
                .collect(Collectors.toMap(n -> n,
                        n -> integers.stream()
                                .distinct()
                                .filter(k -> k + n == 10 || k == n)
                                .toList()));

        Set<List<Integer>> output = new HashSet<>();

        map.keySet()
                .stream()
                .filter(k -> !map.get(k).isEmpty())
                .filter(k -> !(map.get(k).size() < 2))
                .forEach(k -> output.add(map.get(k)));
        System.out.println(output);

    }
}
