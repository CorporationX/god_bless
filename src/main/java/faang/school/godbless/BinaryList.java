package faang.school.godbless;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryList {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40);
        List<String> binary = convertToBinary(list);
        binary.forEach(System.out::println);
    }

    public static List<String> convertToBinary (List<Integer> list) {
        return   list.stream().map(Integer::toBinaryString).toList();

    }
}
