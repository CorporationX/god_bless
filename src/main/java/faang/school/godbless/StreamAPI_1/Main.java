package faang.school.godbless.StreamAPI_1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 4, 2, 7, 8, 3, 5);
        List<String> strings = Arrays.asList("sofa", "among", "armchair", "desk", "cup", "speakers", "lamp", "box", "books",
                "floor", "ceiling", "flowers", "loom bok", "looser", "lower", "knife", "death", "debt");

        int sum = ManyMethods.sumEvenNumber(integers);
        System.out.println(sum);

        int maxElement = ManyMethods.maxElement(integers);
        System.out.println(maxElement);

        double averageValue = ManyMethods.averageValue(integers);
        System.out.println(averageValue);

        long quantityStringsWithSpecificCharacter = ManyMethods.quantityStringsWithSpecificCharacter(strings, 'a');
        System.out.println(quantityStringsWithSpecificCharacter);

        List<String> filteredStrings = ManyMethods.stringsFilter(strings, "lo");
        System.out.println(filteredStrings);

        List<String> stringsSorterByLength = ManyMethods.stringsSorterByLength(strings);//Странный результат работы: Note
        System.out.println(stringsSorterByLength);

        boolean checkerCondition = ManyMethods.checkCondition(strings, (string) -> string.equals("o"));
        System.out.println(checkerCondition);

        int minThatBiggerThanSpecifiedNumber = ManyMethods.minThatBiggerThanSpecifiedNumber(integers, 6);
        System.out.println(minThatBiggerThanSpecifiedNumber);

        List<Integer> lengthsOfStrings = ManyMethods.lengthsOfStrings(strings);
        System.out.println(lengthsOfStrings);

    }

}
