package faang.school.godbless.StreamApiOptional.StreamAPI2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 9, 3, 6, 4, 5);
        Set<List<Integer>> pairs = getPair(nums, 10);
        System.out.println("1. Pairs: " + pairs);

        Map<String, String> countriesCapitalsMap = Map.of("Afghanistan", "Kabul", "Australia", "Canberra",
                "Cuba", "Havana", "Costa Rica", "San Jose", "Canada", "Ottawa", "Estonia", "Tallinn", "Eritrea", "Asmara");
        List<String> capitals = getCapitals(countriesCapitalsMap);
        System.out.println("2. Capitals: " + capitals);

        List<String> strokes = List.of("Dance", "Key", "Job Market", "Margot Robbie", "Abracadabra", "Asta La Vista", "Frog", "Cheese", "Andrew", "Add");
        List<Integer> length = getSortedListOfLengthsOfWordsThatStartsWithLetter(strokes, 'a');
        System.out.println("3. Lengths: " + length);

        Map<String, List<String>> friendsMap = new HashMap<>();
        friendsMap.put("Vlad", List.of("Bob", "Charlie"));
        friendsMap.put("Bob", List.of("Vlad", "Charlie"));
        friendsMap.put("Charlie", List.of("Vlad", "Bob", "David"));
        friendsMap.put("David", List.of("Charlie", "Misha"));
        friendsMap.put("Misha", List.of("David"));

        List<List<String>> mutualNonFriends = findMutualNonFriends(friendsMap);
        System.out.println("4. Mutual non-friends: " + mutualNonFriends);

        Employee employee1 = new Employee("David", 1490, "Education");
        Employee employee2 = new Employee("Marilyn", 1215, "Catering industry");
        Employee employee3 = new Employee("Peeter", 2060, "Management");
        Employee employee4 = new Employee("Misha", 4320, "Management");
        Employee employee5 = new Employee("Vlad", 7800, "IT");
        Employee employee6 = new Employee("Daniel", 4600, "IT");
        Employee employee7 = new Employee("Antony", 1380, "Education");
        Employee employee8 = new Employee("Sydney", 1230, "Catering industry");

        List<Employee> employees = List.of(employee1, employee2, employee3, employee4, employee5, employee6, employee7, employee8);
        Map<String, Double> avgIncome = getDepartmentsAvgIncome(employees);
        System.out.println("5. Avg income: " + avgIncome);


        List<String> words = List.of("apple", "banana", "123", "dog", "cat");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] alphabetArray = alphabet.toCharArray();
        List<String> wordsThatContainAlphabetLetters = getFilteredStrokesThatContainAlphabetLetters(words, alphabetArray);
        System.out.println("6. Words that contain alphabet letters: " + wordsThatContainAlphabetLetters);

        List<Integer> numbers = List.of(5, 3, 10, 15, 20, 21);
        List<String> binaryStrings = convertToBinaryStrings(numbers);
        System.out.println("7. Binary strings: " + binaryStrings);

        List<Integer> numbersList = List.of(5, 13, 303, 1011, 515, 20, 1221);
        List<Integer> isPalindrome = getPallindromes(numbersList);
        System.out.println("8. Palindrome list: " + isPalindrome);

    }

    private static Set<List<Integer>> getPair(List<Integer> nums, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();

        return nums.stream()
                .flatMap(num1 -> nums.stream()
                        .filter(num2 -> num1 + num2 == targetSum)
                        .map(num2 -> {
                            List<Integer> pair = List.of(num1, num2);
                            return pair.stream().sorted().collect(Collectors.toList());
                        }))
                .collect(Collectors.toSet());
    }

    private static List<String> getCapitals(Map<String, String> countriesCapitalsMap) {
        return countriesCapitalsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    private static List<Integer> getSortedListOfLengthsOfWordsThatStartsWithLetter(List<String> strokes, char letter) {
        return strokes.stream()
                .filter(word -> Character.toLowerCase(word.charAt(0)) == Character.toLowerCase(letter))
                .map(String::length)
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<List<String>> findMutualNonFriends(Map<String, List<String>> friendsMap) {
        return friendsMap.entrySet().stream()
                .flatMap(entry1 -> friendsMap.entrySet().stream()
                        .filter(entry2 -> !entry1.getKey().equals(entry2.getKey()))
                        .filter(entry2 -> !entry1.getValue().contains(entry2.getKey()))
                        .filter(entry2 -> !entry2.getValue().contains(entry1.getKey()))
                        .map(entry2 -> {
                            List<String> mutualFriends = new ArrayList<>(entry1.getValue());
                            mutualFriends.retainAll(entry2.getValue());
                            return mutualFriends.isEmpty() ?
                                    Arrays.asList(entry1.getKey(), entry2.getKey()) :
                                    null;
                        })
                        .filter(Objects::nonNull)
                        .map(pair -> {
                            pair.sort(String::compareTo);
                            return pair;
                        })
                )
                .distinct()
                .sorted(Comparator.comparing(pair -> pair.get(0)))
                .collect(Collectors.toList());
    }

    private static Map<String, Double> getDepartmentsAvgIncome(List<Employee> employees){
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingInt(e -> e.getIncome().intValue())));
    }

    public static List<String> getFilteredStrokesThatContainAlphabetLetters(List<String> strokes, char[] alphabetArray) {
        return strokes.stream()
                .filter(word -> word.chars().anyMatch(c -> new String(alphabetArray).indexOf(c) != -1))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinaryStrings(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<Integer> getPallindromes(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> IsPalindrome(number))
                .collect(Collectors.toList());
    }

    public static boolean IsPalindrome(int number){
        return number == IntStream.iterate(number, i -> i / 10)
                .map(n -> n % 10)
                .limit(String.valueOf(number).length())
                .reduce(0, (a, b) -> a = a * 10 + b);
    }
}