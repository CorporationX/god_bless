package faang.school.godbless.BJS223064;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> strings = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        int sumOfEvens = StreamApi.findSumEvenNumbers(numbers);
        System.out.println("The sum of all even numbers: " + "\n" + sumOfEvens + "\n");

        int maxOfNumbers = StreamApi.findMaximumElement(numbers);
        System.out.println("Maximum number in list: " + "\n" + maxOfNumbers + "\n");

        Double averageOfNumbers = StreamApi.findAverageValueNumber(numbers);
        System.out.println("Average of numbers in the list: " + "\n" + averageOfNumbers + "\n");

        int startingSpecificCharacter = StreamApi.findNumberLines("f", strings);
        System.out.println("The number of lines starting with a particular character in a list of lines: " + "\n" + startingSpecificCharacter + "\n");

        List<String> stringList = StreamApi.filterListSubstring("i", strings);
        System.out.println("Filtered lines by a specific substring: " + "\n" + stringList + "\n");

        List<String> sortedByLength = StreamApi.sortListByLength(strings);
        System.out.println("Sorted list by length: " + "\n" + sortedByLength + "\n");

        boolean checkList = StreamApi.checkListForStatement(strings, s -> s.startsWith("f"));
        System.out.println("Do all elements of a list satisfy a certain condition: " + "\n" + checkList + "\n");

        int findMimGiveNum = StreamApi.findMinElementAGiveNumber(3, numbers);
        System.out.println("The smallest element in a list that is greater than a given number: " + "\n" + findMimGiveNum + "\n");

        List<Integer> listConvert = StreamApi.convertListStringToListInt(strings);
        System.out.println("From a list of strings to a list of their lengths: " + "\n" + listConvert + "\n");
    }
}
