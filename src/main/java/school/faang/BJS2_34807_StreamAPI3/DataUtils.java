package school.faang.BJS2_34807_StreamAPI3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataUtils {
    public static Set<List<String>> findMutualFriends(Map<String, List<String>> peopleFriends) {
        Set<List<String>> mutualFriendsPairs = new HashSet<>();
        List<String> persons = new ArrayList<>(peopleFriends.keySet());

        Map<String, Set<String>> peopleFriendsSets = new HashMap<>();
        peopleFriends.forEach((person, personFriends) -> peopleFriendsSets.put(person, new HashSet<>(personFriends)));

        IntStream.range(0, persons.size() - 1)
                .forEach(i -> IntStream.range(i + 1, persons.size())
                        .forEach(j -> {
                            String firstPerson = persons.get(i);
                            String secondPerson = persons.get(j);
                            if (!peopleFriendsSets.get(firstPerson).contains(secondPerson)) {
                                Set<String> personFriends = new HashSet<>(peopleFriendsSets.get(firstPerson));
                                personFriends.retainAll(peopleFriendsSets.get(secondPerson));
                                if (!personFriends.isEmpty()) {
                                    mutualFriendsPairs.add(Arrays.asList(firstPerson, secondPerson));
                                }
                            }
                        })
                );

        return mutualFriendsPairs;
    }

    public static Map<String, Double> departuresAverageSalaries(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDeparture,
                        Collectors.averagingDouble(Employee::getSalary)
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
