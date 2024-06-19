package faang.school.godbless.BJS2_10535;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> listSt = Arrays.asList("Apple", "Array", "List", "Map", "Arrays");

        System.out.println("even sum " + Util.sumEven(list));
        System.out.println("max " + Util.findMax(list));
        System.out.println("average " + Util.findAverage(list));
        System.out.println("count " + Util.countStartFrom(listSt, "A"));
        System.out.println("contains " + Util.filterContains(listSt, "Arr"));
        System.out.println("length sort " + Util.sortLength(listSt));
        System.out.println("allMatch " + Util.allMatch(listSt, x -> x.length() == 3));
        System.out.println("min bigger than " + Util.findMinBiggerThan(list, 5));
        System.out.println("list of length " + Util.mapToLength(listSt));
    }
}
