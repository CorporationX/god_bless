package faang.school.godbless.StreamAPI1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6);
        intList.stream()
                .filter(num1 -> num1 % 2 == 0)
                .forEach(num -> System.out.println(num));
//        int sumEvenNumbers = intList.stream()/
    }
}
