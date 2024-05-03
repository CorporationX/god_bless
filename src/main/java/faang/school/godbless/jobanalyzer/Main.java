package faang.school.godbless.jobanalyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        Stream<Integer> stream1 = Stream.iterate(2, m -> m + 4).limit(9);
        int k = stream1
                .reduce(10000000, Integer::sum);
        System.out.println(k);
    }
}
