package faang.school.godbless.stream_api.task1stream;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5);
        List<String> strings = List.of("dddd","dd","dddddd");

        System.out.println(StreamMethods.chetNumber(numbers));
        System.out.println(StreamMethods.maxNumber(numbers));
        System.out.println(StreamMethods.averageNumber(numbers));
        System.out.println(StreamMethods.countStartStr(strings, 'd'));
        System.out.println(StreamMethods.countContainsStr(strings, "ddd"));
        System.out.println(StreamMethods.sortStr(strings));
        System.out.println(StreamMethods.containsStrAll(strings, "dd"));
        System.out.println(StreamMethods.findMinNumber(numbers, 3));
        System.out.println(StreamMethods.convertStrInLength(strings));
    }
}
