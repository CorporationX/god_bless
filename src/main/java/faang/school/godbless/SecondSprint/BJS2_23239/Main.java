package faang.school.godbless.SecondSprint.BJS2_23239;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        String stringTest = "Returns a stream consisting of the results of replacing each element of this stream";
        List<String> stringList = Arrays.stream(stringTest.split(" ")).toList();

        System.out.println(Manager.getLenghtOfStrings(stringList));
    }
}
