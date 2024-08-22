package faang.school.godbless;

import java.util.List;
import java.util.Optional;

import static faang.school.godbless.FilterTheListOfStrings.filterStringsContainingSubstring;
import static faang.school.godbless.NumberOfLinesStartingWithCharacter.numberOfLinesStartingWithCharacter;
import static faang.school.godbless.TheSortedListByStringLength.sortedListByStringLength;

public class Application {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,34,4,11,6,15,8,20);
        int sumResult = TheSumOfEvenNumbers.sumOfEvenNumbers(list);
        System.out.println("The sum of even numbers is - " + sumResult);

        int maxNumber = MaximumElement.findMaximumElement(list);
        System.out.println("The maximum element in the list is the number - " + maxNumber);

        double averageNumber = AverageValue.findAverageValue(list);
        System.out.println("The average value in the list of numbers is - " + averageNumber);

        List<String> stringList = List.of("one", "two", "three", "four", "five", "six", "fourteen", "eight", "nine", "ten");
        char startingChar = 't';
        long count = numberOfLinesStartingWithCharacter(stringList, startingChar);
        System.out.println("The number of lines starting with " + "\"" + startingChar + "\"" + " is - " + count);

        String substring = "fou";
        List<String> filteredString = filterStringsContainingSubstring(stringList, substring);
        System.out.println("A list of strings that contains the substring " + "\"" + substring + "\"" + " is - " + filteredString);

        List<String> sortedLength = sortedListByStringLength(stringList);
        System.out.println("The sortedListByStringLength is - " + sortedLength);

        boolean rezult = CheckAllElements.allElementsMatchCondition(stringList);
        System.out.println("Does the list consist of Latin alphabet letters? That's" + " - " + rezult);

        int checkElement = 13;
        Optional<Integer> result = TheSmallestElementInTheList.smallestElementInTheList(list, checkElement);
        if (result.isPresent()) {
            System.out.println("Smallest element greater than " + checkElement + " is - " + result.get());
        } else {
            System.out.println("No element greater than " + checkElement );
        }

        List<Integer> listInt = ConvertStringsToLengths.convertToLengths(stringList);
        System.out.println("Transformed list of strings " + stringList +
                "\n into a list of their lengths - " + listInt);
    }
}