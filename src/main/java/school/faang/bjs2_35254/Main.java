package school.faang.bjs2_35254;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(getUniquePairs(list, 7));
    }

    public static Map<Integer, Integer> getUniquePairs(List<Integer> list, int number) {
        list.stream().filter(n -> n <= number)
    }
}
