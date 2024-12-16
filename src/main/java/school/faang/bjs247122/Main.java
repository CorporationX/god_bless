package school.faang.bjs247122;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<Integer> integerList = List.of(1, 2, 3, 4, 500);
        final List<String> namesStudent = List.of("Alice", "Anna", "Bob", "Boris", "John");

        List<Integer> integers = ListOperations.transformationWordInLength(namesStudent);
        System.out.println("Length names in our list student = " + integers);

        List<String> subString = ListOperations.containsSubstring(namesStudent, "bo");
        System.out.println("Names student that contain substring 'bo' = " + subString);

        List<String> sortedWord = ListOperations.sortedWordByLength(namesStudent);
        System.out.println("Sorted list student by length names = " + sortedWord);

        System.out.println("Sum even numbers in our list = " + ListOperations.sumEvenNumbers(integerList));
        System.out.println("Max element in our list = " + ListOperations.maxElement(integerList));
        System.out.println("Average num in our list = " + ListOperations.averageNum(integerList));
        System.out.println("Count names students start with char 'A' in our list = "
                + ListOperations.countWordsWithChar(namesStudent, 'A'));

        System.out.println("Next min num in our list after '200' = "
                + ListOperations.findMinGreaterThan(integerList, 200));

        System.out.println("All nums even in our list? "
                + ListOperations.filterListByCondition(integerList, num -> num % 2 == 0));
    }
}
