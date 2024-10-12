package school.faang.BJS2_34807_StreamAPI3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DataUtils {
    public static Set<List<String>> findMutualFriends(Map<String, List<String>> peopleFriends) {
        Set<List<String>> mutualFriendsPairs = new HashSet<>();

        peopleFriends.forEach((person, personFriends) ->
                personFriends.stream()
                        .flatMap(personFriend -> peopleFriends.get(personFriend).stream())
                        .filter(friendOfFriend -> !friendOfFriend.equals(person) && !personFriends.contains(friendOfFriend))
                        .forEach(friendOfFriend -> {
                            List<String> mutualFriendsPair = Arrays.asList(person, friendOfFriend);
                            mutualFriendsPair.sort(String::compareTo);
                            mutualFriendsPairs.add(mutualFriendsPair);
                        })
        );

        return mutualFriendsPairs;
    }

    public static Map<String, Double> departuresAverageSalaries(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDeparture))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        departureEmployees -> departureEmployees.getValue().stream()
                                .mapToDouble(Employee::getSalary)
                                .average()
                                .orElse(0.0)
                ));
    }

    public static List<Integer> getPalindromes(int startNumber, int endNumber) {
        return IntStream.rangeClosed(startNumber, endNumber)
                .boxed()
                .filter(number -> {
                    String strNumber = String.valueOf(number);
                    String strNumberReversed = new StringBuilder(strNumber).reverse().toString();
                    return strNumber.equals(strNumberReversed);
                })
                .toList();
    }

    public static Set<String> getSubstringsPalindromes(String input) {
        Set<String> substringsPalindromes = new HashSet<>();

        IntStream.rangeClosed(0, input.length() - 1)
                .forEach(startIndex -> IntStream.rangeClosed(startIndex + 1, input.length())
                        .forEach(endIndex -> {
                            String substring = input.substring(startIndex, endIndex);
                            String substringReversed = new StringBuilder(substring).reverse().toString();
                            if (substring.equals(substringReversed)) {
                                substringsPalindromes.add(substring);
                            }
                        })
                );

        return substringsPalindromes;
    }

    public static List<Integer> getPerfectNumbers(int startNumber, int endNumber) {
        return IntStream.rangeClosed(startNumber, endNumber)
                .filter(DataUtils::isPerfectNumber)
                .boxed()
                .toList();
    }

    private static boolean isPerfectNumber(Integer number) {
        int sumOfDivisors = IntStream.rangeClosed(1, (int)Math.sqrt(number))
                .filter(possibleDivisor -> number % possibleDivisor == 0)
                .map(divisor -> {
                    int pairDivisor = number / divisor;
                    return divisor == pairDivisor ? divisor : pairDivisor + divisor;
                })
                .sum();

        return sumOfDivisors - number == number;
    }
}
