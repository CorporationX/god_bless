package faang.school.godbless.practiceStreamAPI2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamApiMethods {
    public Map<Integer, Integer> pairsForTargetNum(int targetNum, List<Integer> nums) {
        Map<Integer, Integer> resultPairs = new HashMap<>();
        List<Integer> copyNum = new ArrayList<>(nums);

        for (int i = 0; i < copyNum.size(); i++) {
            for (int j = 0; j < copyNum.size(); j++) {
                if (copyNum.get(i) == copyNum.get(j)) {
                    continue;
                }

                if (copyNum.get(i) + copyNum.get(j) == targetNum) {
                    int numOne = copyNum.get(i);
                    int numTwo = copyNum.get(j);

                    resultPairs.put(copyNum.get(i), copyNum.get(j));

                    copyNum.removeIf(num -> num == numOne || num == numTwo);
                }
            }
        }
        return resultPairs;
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

        employees.forEach(employee -> {
            if (departments.containsKey(employee.department())) {
                List<Integer> salariesForDepartment = departments.get(employee.department());
                salariesForDepartment.add(employee.salary());

                departments.put(employee.department(), salariesForDepartment);
            } else {
                departments.put(employee.department(), new ArrayList<>());
                departments.get(employee.department()).add(employee.salary());
            }
        });

        Map<String, Double> averageSalaryForDepartments = new HashMap<>();
        departments.entrySet()
                .forEach(entry -> {
                    averageSalaryForDepartments.put(entry.getKey(), entry.getValue().stream()
                            .mapToDouble(salary -> salary)
                            .average().getAsDouble());
                });

        return averageSalaryForDepartments;
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
        for (int i = start; i <= end; i++) {
            String number = Integer.toString(i);
            StringBuilder reversed = new StringBuilder(number).reverse();

            if (number.contentEquals(reversed)) {
                palindromes.add(i);
            }
        }
        return palindromes;
    }
}
