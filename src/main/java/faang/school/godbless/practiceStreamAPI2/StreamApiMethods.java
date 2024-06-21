package faang.school.godbless.practiceStreamAPI2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamApiMethods {
    public List<List<Integer>> pairsForTargetNum(int targetNum, List<Integer> nums) {

        return nums.stream()
                .filter(integer -> nums.contains(targetNum - integer))
                .filter(integer -> nums.indexOf(integer) != nums.lastIndexOf(targetNum - integer))
                .map(integer -> List.of(Math.min(integer, targetNum - integer), Math.max(integer, targetNum - integer)))
                .distinct().toList();
    }

    public void printSortedListCountryCapital(Map<String, String> countries) {
        countries.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> {
            System.out.println(entry.getValue());
        });
    }

    public List<String> filterAndSortByLength(List<String> words, Character symbol) {
        List<String> filteredWords = new ArrayList<>(words);

        return filteredWords.stream()
                .filter(word -> word.startsWith(symbol.toString()))
                .sorted((wordOne, wordTwo) -> wordTwo.length() - wordOne.length())
                .toList();
    }

    public Map<String, String> findPeopleNotFriendsButWithMutualFriends(Map<String, List<String>> peoples) {
        Map<String, String> peopleWithMutualFriends = new HashMap<>();

        peoples.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entryOne -> {
                    peoples.entrySet().stream()
                            .forEach(entryTwo -> {
                                if (!entryOne.getKey().equals(entryTwo.getKey())) {
                                    if (!entryOne.getValue().contains(entryTwo.getKey())) {
                                        entryOne.getValue().forEach(name -> {
                                            if (entryTwo.getValue().contains(name)) {
                                                if (!peopleWithMutualFriends.containsKey(entryTwo.getKey())) {
                                                    peopleWithMutualFriends.put(entryOne.getKey(), entryTwo.getKey());
                                                }
                                            }
                                        });
                                    }
                                }
                            });
                });
        return peopleWithMutualFriends;
    }

    public Map<String, Double> countAvgSalaryForDepartments(List<Employee> employees) {
        Map<String, List<Integer>> departments = new HashMap<>();


    }

    public List<String> filterAndSortStringsByAlphabet(List<String> words, List<Character> alphabet) {
        List<String> filteredWords = new ArrayList<>(words);

        return filteredWords.stream().filter(word -> {
            for (Character character : word.toCharArray()) {
                if (!alphabet.contains(character)) {
                    return false;
                }
            }
            return true;
        }).sorted((wordOne, wordTwo) -> wordTwo.length() - wordOne.length()).toList();
    }

    public List<String> convertsIntegersIntoBinary(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString).toList();
    }

    public List<Integer> palindromeNumbersInTheRange(int start, int end) {
        List<Integer> palindromes = new ArrayList<>();

        return palindromes;
    }
}
