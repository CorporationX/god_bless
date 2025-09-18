package school.faang.bjs2_87982_stream_API2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(Methods.findUniqueNumbersPairWithSum(numbers, 6));
    }
}
