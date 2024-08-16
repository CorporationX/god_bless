package faang.school.godbless.streamApiTest2;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 1, 4, 5);

        list.stream()
                .flatMap(x -> list.stream().skip(list.indexOf(x) + 1)
                        .flatMap(y -> Stream.of(new int[]{x, y}))).distinct()
//                .filter(x -> x[0] + x[1] == 3)
//                .toList()
                .forEach(x -> System.out.println(Arrays.toString(x)));
    }
}
