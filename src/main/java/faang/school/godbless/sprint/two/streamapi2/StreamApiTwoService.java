package faang.school.godbless.sprint.two.streamapi2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StreamApiTwoService {


    // GPT helped to solve this task
    public static List<List<Integer>> findPairsInListEqualInputNumber(List<Integer> numbers, int inputNumber) {
        Set<Integer> seenNumbers = new HashSet<>();

        return IntStream.range(0, numbers.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, numbers.size())
                        .filter(j -> numbers.get(i) + numbers.get(j) == inputNumber)
                        .mapToObj(j -> List.of(numbers.get(i), numbers.get(j))))
                .filter(pair -> seenNumbers.add(pair.get(0)) && seenNumbers.add(pair.get(1)))
                .collect(Collectors.toList());
    }


    public static List<String> findCapitalsSortedByCountries(Map<String, String> countryCapitals) {
        return countryCapitals.entrySet()
                .stream().sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> getFilteredByLetterAndSortedByLengthStrings(List<String> strings, char letter) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    // GPT helped to solve this task
    public static List<List<String>> findPeopleWhoHasCommonFriends(Map<String, List<String>> friends) {
        return friends.keySet().stream()
                .flatMap(person1 -> friends.keySet().stream()
                        .filter(person2 -> !person1.equals(person2))
                        .filter(person2 -> !friends.get(person1).contains(person2))
                        .filter(person2 -> {
                            Set<String> commonFriends = new HashSet<>(friends.get(person1));
                            commonFriends.retainAll(friends.get(person2));
                            return !commonFriends.isEmpty();
                        })
                        .map(person2 -> {
                            List<String> pair = Arrays.asList(person1, person2);
                            pair.sort(Comparator.naturalOrder());
                            return pair;
                        })
                )
                .distinct()
                .toList();
    }

    public static Map<String, Double> getAverageSalaryForDepartments(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    private static boolean isWordContainsOnlySpecificLetters(String word, String letters) {
        Set<Character> checkLetters = new HashSet<>();
        for (int i = 0; i < letters.length(); i++) {
            checkLetters.add(letters.charAt(i));
        }

        for (int i = 0; i < word.length(); i++) {
            if (!checkLetters.contains(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static List<String> filterByInputStringOfLettersAndSortWords(List<String> strings, String letters) {
        return strings.stream()
                .filter(w -> StreamApiTwoService.isWordContainsOnlySpecificLetters(w, letters))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertNumbersToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    private static boolean isPalindrome(int n) {
        int reverse = 0;
        int temp = n;

        while (temp > 0) {
            reverse = reverse * 10 + temp % 10;
            temp = temp / 10;
        }

        return n == reverse;
    }

    public static List<Integer> findPalindromeInRange(int first, int last) {
        return IntStream.range(first, last)
                .boxed()
                .filter(StreamApiTwoService::isPalindrome)
                .toList();
    }

}
