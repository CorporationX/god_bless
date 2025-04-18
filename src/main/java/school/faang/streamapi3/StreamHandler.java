package school.faang.streamapi3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamHandler {
    public static List<List<String>> getWithMutualFriends(Map<String, List<String>> people) {
        return people.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .filter(entryPerson -> isPairExists(people, entryPerson))
                .map(entryForPair -> getPair(people, entryForPair))
                .peek(Collections::sort)
                .distinct()
                .toList();
    }

    private static List<String> getPair(Map<String, List<String>> people,
                                        Map.Entry<String, List<String>> entryForPair) {
        Map.Entry<String, List<String>> pairEntry = people.entrySet().stream()
                .filter(potentialPair -> isPairPerConditions(potentialPair, entryForPair))
                .findFirst()
                .get();
        return Arrays.asList(entryForPair.getKey(), pairEntry.getKey());
    }

    private static boolean isPairExists(Map<String, List<String>> people,
                                        Map.Entry<String, List<String>> entryPerson) {
        return people.entrySet().stream()
                .anyMatch(potentialPair -> isPairPerConditions(potentialPair, entryPerson));
    }

    private static boolean isPairPerConditions(Map.Entry<String, List<String>> potentialPair,
                                               Map.Entry<String, List<String>> entryToBePaired) {
        return !Objects.equals(potentialPair.getKey(), entryToBePaired.getKey())
                && Objects.equals(potentialPair.getValue(), entryToBePaired.getValue());
    }

    public static Map<String, Double> getDeptAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<Integer> getPalindromInRage(Integer firstNum, Integer lastNum) {
        return IntStream.range(firstNum, lastNum + 1)
                .boxed()
                .map(String::valueOf)
                .filter(num -> num.contentEquals(new StringBuilder(num).reverse()))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<String> getPalindromsForString(String inputString) {
        Set<String> palindromes = new HashSet<>();
        int j, k;

        for (int i = 0; i < inputString.length(); i++) {
            palindromes.add(String.valueOf(inputString.charAt(i)));
            j = i + 1;
            k = i - 1;
            boolean isTheSameSymbol = true;
            while (k >= 0 && j < inputString.length() - 1) {
                if (checkIfDifferentChar(inputString.charAt(k + 1), inputString.charAt(i), inputString.charAt(j - 1))) {
                    isTheSameSymbol = false;
                }
                if (inputString.charAt(k) == inputString.charAt(j - 1) && isTheSameSymbol) {
                    palindromes.add(inputString.substring(k, j));
                }
                if (inputString.charAt(k + 1) == inputString.charAt(j) && isTheSameSymbol) {
                    palindromes.add(inputString.substring(k + 1, j + 1));
                }
                if (inputString.charAt(k) == inputString.charAt(j)) {
                    palindromes.add(inputString.substring(k, j + 1));
                } else {
                    break;
                }
                k--;
                j++;
            }
        }
        return List.copyOf(palindromes);
    }

    private static boolean checkIfDifferentChar(char leftChar, char middleChar, char rightChar) {
        return leftChar != middleChar || leftChar != rightChar;
    }

    public static List<Integer> getPerfectNumbers(Integer firstNum, Integer lastNum) {
        return IntStream.range(firstNum, lastNum + 1)
                .filter(num -> {
                    List<Integer> delimeters = new ArrayList<>();
                    for (int i = 1; i < num; i++) {
                        boolean isDelimeter = num % i == 0;
                        if (isDelimeter) {
                            delimeters.add(i);
                        }
                    }
                    int sum = 0;
                    for (Integer j : delimeters) {
                        sum += j;
                    }
                    return sum == num;
                })
                .boxed()
                .toList();
    }
}
