package faang.school.godbless.streams.task_2.utils;

import faang.school.godbless.streams.task_2.model.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamUsageExample {
    public void printTermsForNumber(List<Integer> numbers, int number) {
        Set<Integer> nums = new HashSet<>(numbers);
        Map<Integer, Integer> terms = new HashMap<>();
        numbers.stream()
                .filter(num -> nums.contains(number - num) && num != number - num)
                .forEach((num) -> {
                    if (!terms.containsKey(number - num)) {
                        terms.put(num, number - num);
                    }
                });
        terms.forEach((key, value) -> System.out.printf("[%d, %d]%n", key, value));
    }

    public List<String> getCapitalsList(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> getSortedWordsListStartedWith(char symbol, List<String> strings) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public Map<String, String> findPairsWithMutualFriends(Map<String, List<String>> friends) {
        Map<String, String> pairs = new HashMap<>();
        friends.forEach((firstFriend, friendsOfFirstFriend) -> {
            friends.entrySet().stream()
                    .filter(friend -> !friendsOfFirstFriend.contains(friend.getKey())
                            && !friend.getKey().equals(firstFriend))
                    .forEach(friend -> friend.getValue().stream()
                            .filter(fr -> friendsOfFirstFriend.contains(fr))
                            .forEach(name -> {
                                if (!pairs.containsKey(friend.getKey())) {
                                    pairs.put(firstFriend, friend.getKey());
                                }
                            }));
        });
        return pairs;
    }

    public Map<String, Double> getAverageSalariesOfDepartments(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    public List<String> getSortedWordsListContainsLetters(List<String> words, String[] letters) {
        List<String> alphabet = Arrays.asList(letters);
        return words.stream()
                .filter(word -> Arrays.stream(word.split(""))
                        .allMatch(letter -> alphabet.contains(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public List<String> getListOfBinaryNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> Integer.toBinaryString(number))
                .collect(Collectors.toList());
    }

    public List<Integer> getPalindromeNumbers(int start, int finish) {
        return IntStream.range(start, finish)
                .mapToObj(number -> String.valueOf(number))
                .filter(num -> new StringBuilder(num).reverse().toString().equals(num))
                .map(word -> Integer.valueOf(word))
                .collect(Collectors.toList());
    }

    public List<String> getPalindromeStrings(String word) {
        Set<String> palindromes = new HashSet<>();
        IntStream.range(0, word.length())
                .forEach(index -> IntStream.range(0, word.length())
                        .filter(ind -> index + ind <= word.length())
                        .mapToObj(ind -> word.substring(index, index + ind))
                        .filter(subWord -> subWord.trim().length() > 1)
                        .filter(substring -> new StringBuilder(substring).reverse().toString().equals(substring))
                        .filter(w -> !w.contains(" "))
                        .collect(Collectors.toCollection(() -> palindromes)));
        return new ArrayList<>(palindromes);
    }

    public List<Integer> getPerfectNumbers(int start, int finish) {
        return IntStream.range(start, finish)
                .filter(num ->
                        IntStream.range(1, num)
                                .filter(d -> num % d == 0)
                                .sum() == num)
                .boxed().toList();
    }
}