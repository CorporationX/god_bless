package school.faang.bjs2_35668;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MathOperation {

    public static int processNumbers(List<Integer> numbers) {

        int sum = 0;
        for (Integer numbersFromTheList : numbers) {
            if (numbersFromTheList % 2 == 0) {
                sum += numbersFromTheList;
            }
        }
        return sum;
    }

    public static int findMaxNumber(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }
        int max = numbers.get(0);
        for (int maxNumber : numbers) {
            if (maxNumber > max) {
                max = maxNumber;
            }
        }
        return max;
    }

    public static double findAverage(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }
        int sum = 0;
        for (int averageNumber : numbers) {
            sum += averageNumber;
        }
        return (double) sum / numbers.size();
    }

    public static int numbersOfCharacters(List<String> strings, char characters) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }
        int sumChar = 0;
        for (String howMany : strings) {
            if (howMany.charAt(0) == characters) {
                sumChar++;
            }
        }
        return sumChar;
    }

    public static List<String> filterList(List<String> strings, String subString) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }

        return strings.stream()
                .filter(s -> {
                    System.out.println("Checking: '" + s + "' contains '" + subString + "'");
                    return s.toLowerCase().contains(subString.toLowerCase().trim());
                })
                .collect(Collectors.toList());
    }

    public static List<String> sortedList(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }
        return strings.stream()
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .collect(Collectors.toList());
    }

    public static boolean meetAllRequirements(List<Integer> requirements1, Predicate<Integer> requirements2) {
        if (requirements1 == null || requirements1.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }

        return requirements1.stream().allMatch(requirements2);
    }

    public static int findMinNumber(List<Integer> numbers, int value) {


        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }
            int min = Integer.MAX_VALUE;
            boolean found = false;

            for (int minNumber : numbers) {
                if (minNumber > value && minNumber < min) {
                    min = minNumber;
                    found = true;
                }
            }
            if (!found) {
                throw new IllegalArgumentException("No number greater that the specified number");
            }


        return min;
    }
    public static List<Integer> listLength(List<String> strings){
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

}
