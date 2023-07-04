package faang.school.godbless;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI2 {

    public Set<Pair<Integer>> findUniquePairs(List<Integer> nums, int targetSum) {
        Set<Integer> processedNumbers = new HashSet<>();
        Set<Pair<Integer>> pairs = new HashSet<>();
        nums.forEach(
                number -> {
                    if (processedNumbers.contains(targetSum - number)) {
                        pairs.add(new Pair<Integer>(Integer.max(number, targetSum - number), Integer.min(number, targetSum - number)));
                    } else {
                        processedNumbers.add(number);
                    }
                }
        );
        return pairs;
    }

    public List<String> sortCountries(Map<String, String> counties) {
        return counties.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> sortStrings(List<String> words, char firstSymbol) {
        return words.stream()
                .filter(word -> !word.isBlank() && word.charAt(0) == firstSymbol)
                .sorted(Comparator.comparing(String::length)).toList();
    }

    //Понял, осознал, благодарю :)
    public Set<Pair<String>> findPossibleFriends(Map<String, List<String>> userFriends) {
        Set<String> processedFriend = new HashSet<>();
        return userFriends.entrySet().stream()
                .flatMap(entry1 -> userFriends.entrySet().stream()
                        .filter(entry2 -> !entry1.getKey().equals(entry2.getKey()))
                        .filter(entry2 -> !entry1.getValue().contains(entry2.getKey()))
                        .filter(entry2 -> !entry2.getValue().contains(entry1.getKey()))
                        .filter(entry2 -> entry1.getValue().stream().anyMatch(entry2.getValue()::contains))
                        .filter(entry2 -> !processedFriend.contains(entry2.getKey()))
                        .map(entry2 -> {
                            processedFriend.add(entry1.getKey());
                            return new Pair<String>(entry1.getKey(), entry2.getKey());
                        })
                ).collect(Collectors.toSet());
    }


    public Map<String, Double> calculateAvgSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary))
                );
    }

    public List<String> stringFilter(List<String> strings, String alphabet) {
        List<String> alphabetList = Collections.singletonList(alphabet);
        return strings.stream()
                .filter(s -> s.matches("[" + alphabet + "]+"))
                .filter(s -> s.matches("[a-zA-Z]+"))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public List<String> intToString(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<Integer> getPalindromes(int start, int end) {
        var result = Stream.iterate(start, c -> c + 1)
                .limit(end - start + 1)
                .filter(
                        num -> {
                            String str = Integer.toString(num);
                            int left = 0;
                            int right = str.length() - 1;

                            while (left < right) {
                                if (str.charAt(left) != str.charAt(right)) {
                                    return false;
                                }
                                left++;
                                right--;
                            }
                            return true;
                        }
                ).toList();
        return result;
    }

}
