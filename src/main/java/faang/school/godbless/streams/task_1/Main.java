package faang.school.godbless.streams.task_1;

import faang.school.godbless.streams.task_1.util.ListUtil;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListUtil listUtil = new ListUtil();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> strings = Arrays.asList("apple", "fruit", " ", "apply", "opp");
        System.out.println(listUtil.sumEvenNumbers(numbers));
        System.out.println(listUtil.findMaxNumber(numbers));
        System.out.println(listUtil.findAverageNumber(numbers));
        System.out.println(listUtil.countStringsStartsWithSymbol('a', strings));
        System.out.println(listUtil.collectStringsContainsSubstring("app", strings));
        System.out.println(listUtil.sortListByStringsLength(strings));
        System.out.println(listUtil.checkListElements(numbers, (number) -> number > 15));
        System.out.println(listUtil.findMinElementWhichMoreThanThreshold(2, numbers));
        System.out.println(listUtil.convertStringsToStringLengths(strings));
    }
}