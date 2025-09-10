package school.faang.bsj2_89333;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1
        List<Integer> integersForTask1 = List.of(1, 2, 3, 4, 5, 6, 7);
        System.out.println("evenNumbersSum = " + StreamApiTrainer.getEvenDigitsSum(integersForTask1));
        // 2
        List<Integer> integersForTask2 = List.of(2, 3, 6, 1, 4, 10, 7, 19, 0);
        System.out.println("Max value = " + StreamApiTrainer.getMaxValue(integersForTask2));
        // 3
        List<Integer> integersForTask3 = List.of(1, 2, 3);
        System.out.println("Average value = " + StreamApiTrainer.calculateAverageValue(integersForTask3));
        // 4
        List<String> stringsForSearch = List.of("lala", "kaka", "jaja", "haha", "lolo");
        System.out.println("Count of string = " + StreamApiTrainer.countStringsStartsWith(stringsForSearch, 'l'));
        // 5
        List<String> stringsForCheck = List.of("assa", "dasa", "dafa", "gaga", "haha");
        System.out.println("Checked List = " + StreamApiTrainer.getStringsContains(stringsForCheck, "da"));
        // 6
        List<String> stringsForSort = List.of("aaa", "bb", "c", "dddd", "eee", "ff", "j");
        System.out.println("Sorted List = " + StreamApiTrainer.sortStringsByLength(stringsForSort));
        // 7
        List<Integer> integersForCheck = List.of(44, 55, 66, 77, 88, 99);
        System.out.println("Check result = " +
                StreamApiTrainer.areAllElementsTrue(integersForCheck, (integer -> integer > 40)));
        // 8
        List<Integer> integersForSortAndCheck = List.of(495, 5886, 2947, 2111, 14905, 1, 58392);
        System.out.println("Sort and check result = " +
                StreamApiTrainer.getMinValueWithCheck(integersForSortAndCheck, 2200));
        // 9
        List<String> stringForTransformation = List.of("a", "bb", "ccc", "hello", "hi", "howareyou", "fine");
        System.out.println("Transformed list = " + StreamApiTrainer.getStringLengths(stringForTransformation));
    }
}
