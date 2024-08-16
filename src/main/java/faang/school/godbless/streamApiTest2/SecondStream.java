package faang.school.godbless.streamApiTest2;

import java.util.List;
import java.util.stream.Stream;

public class SecondStream {
    public static List<int[]> doThePairsThatSummaryA(List<Integer> list, int a) {
        return list.stream()
                .flatMap(x -> list.stream().skip(list.indexOf(x) + 1)
                        .flatMap(y -> Stream.of(new int[]{x, y})))
                .filter(x -> x[0] + x[1] == a)
                .toList();
    }
}
