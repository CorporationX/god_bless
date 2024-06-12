package faang.school.godbless.kalculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listNumbers = List.of(1, 3, 5);
        System.out.println(CalculateList.product(listNumbers));
        System.out.println(CalculateList.sum(listNumbers));
    }
}