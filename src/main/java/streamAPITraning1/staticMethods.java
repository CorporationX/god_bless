package streamAPITraning1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class staticMethods {
    public int getSumOfEvenNums(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public int getMax(List<Integer> nums) {
        return nums.stream()
                .max(Integer::compare)
                .orElse(0);
    }

    public double getAverage(List<Integer> nums) {
        return nums.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0);
    }

    public int getCountLinesOfStaringWithSubstring(List<String> lines, String substring) {
        return (int) lines.stream()
                .filter(line -> line.startsWith(substring))
                .count();
    }

    public List<String> getLinesWithSubstring(List<String> lines, String substring) {
        return lines.stream()
                .filter(line -> line.contains(substring))
                .toList();
    }

    public List<String> sortByLength(List<String> lines) {
        return lines.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public boolean checkCondition(List<String> lines, Predicate<String> predicate) {
        return lines.stream()
                .anyMatch(predicate);
    }

    public int getMinOfMoreThanNumber(List<Integer> nums, int number) {
        return nums.stream()
                .filter(num -> num > number)
                .min(Integer::compare)
                .orElse(0);
    }

    public List<Integer> ConvertStringsToTheirLengths(List<String> lines) {
        return lines.stream()
                .map(String::length)
                .toList();
    }
}