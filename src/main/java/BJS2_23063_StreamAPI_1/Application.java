package BJS2_23063_StreamAPI_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> strings = Arrays.asList("Hi", "Hey-ho!", "This is", "Just", "a", "Test", "list");

        //sum of all elements
        System.out.println(nums.stream().mapToInt(i -> i).sum());
        //maximum
        System.out.println(nums.stream().mapToInt(i -> i).max().getAsInt());
        //average
        System.out.println(nums.stream().mapToInt(i -> i).average().getAsDouble());
        //count strings that starts with "H"
        System.out.println(strings.stream().filter(s -> s.startsWith("H")).count());
        //list with specific substring
        System.out.println(strings.stream().filter(s -> s.contains("st")).collect(Collectors.toList()));
        //sort strings by length
        System.out.println(strings.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList()));
        //check if satisfies specific condition
        System.out.println(nums.stream().filter(x -> x > 5).collect(Collectors.toList()));
        //find minimum element that is more than given number
        System.out.println(nums.stream().mapToInt(i -> i).filter(x -> x > 5).min().getAsInt());
        //Strings list -> strings.length list
        System.out.println(strings.stream().map(String::length).collect(Collectors.toList()));
    }
}
