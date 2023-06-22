package faang.school.godbless.StreamApi1;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {
    public static int getSumOfHonestNumber(int[] integers) {
        IntStream intStream = Arrays.stream(integers);
        int sum = intStream
                .filter(i -> i % 2 == 0)
                .sum();
        return sum;
    }
    public static int getMaxNumber(int[] integers) {
        IntStream intStream = Arrays.stream(integers);
        OptionalInt max = intStream.max();
        return max.getAsInt();
    }

    public static double getMiddleNumber(int[] integers) {
        IntStream intStream = Arrays.stream(integers);
        OptionalDouble average = intStream.average();
        return average.getAsDouble();
    }

    public static int getCountOfOneLetterStrings(List<String> strings, char letter){
        strings.stream().filter()
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        System.out.println(getSumOfHonestNumber(a));
        System.out.println(getMaxNumber(a));
        System.out.println(getMiddleNumber(a));
    }
}
