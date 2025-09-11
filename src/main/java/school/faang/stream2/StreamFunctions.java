package school.faang.stream2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFunctions {
    public List<int[]> uniquePair(Set<Integer> set, int pairSum) {
        List<int[]> pairs = new ArrayList<>();
        List<Integer> list = new ArrayList<>(set);
        return IntStream.range(0, list.size())
                .boxed()
                .flatMap(i ->
                        IntStream.range(i + 1, list.size())
                                .filter(j -> list.get(i) + list.get(j) == pairSum)
                                .mapToObj(j -> new int[]{list.get(i), list.get(j)})
                )
                .collect(Collectors.toList());
    }

    public List<String> sortLand(Map<String, String> map) {
        return map.entrySet()
                .stream()
                .filter(entry -> getKey()
    }
}


