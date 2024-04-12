package faang.school.godbless.BJS2_5193;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIService {
    public static Set<Set<Integer>> findAllUniquePairsWhoseSumIsEqualToNumber(List<Integer> inputList, int inputNumber) {
        return inputList.stream().flatMap(num1 -> inputList.stream()
                .filter(num2 -> num1 < num2 && num1 + num2 == inputNumber)
                .map(num2 -> Set.of(num1, num2))).collect(Collectors.toSet());
    }

    public static List<String> takeNameOfCapitalFromCountryAlphabetically(Map<String, String> countryAndCapital) {
        return countryAndCapital.entrySet().stream().sorted(Map.Entry.comparingByKey()).
                map(Map.Entry::getValue).collect(Collectors.toList());
    }

    public static List<String> sortAndFilterStringByChar(List<String> inputStrings, char symbol) {
        return inputStrings.stream().filter(str -> str.charAt(0) == symbol).
                sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    public static List<String> findUnfamiliarPeopleWithMutualFriends(Map<String, List<String>> userMap) {
        return userMap.entrySet().stream().flatMap(entry1 -> userMap.entrySet().stream()
                .filter(entry2 -> !entry1.getKey().equals(entry2.getKey()))
                .filter(entry2 -> !entry1.getValue().contains(entry2.getKey()))
                .filter(entry2 -> entry1.getValue().stream().anyMatch(entry2.getValue()::contains))
                .map(entry2 ->{
                    String name1 = entry1.getKey();
                    String name2 = entry2.getKey();
                    return name1.length() != name2.length() ?
                            (name1.length() < name2.length() ?  name1 + " - " + name2 : name2 + " - " + name1) :
                            Stream.of(name1, name2).sorted().collect(Collectors.joining(" - "));
                })).distinct().toList();
    }

    public static Map<String, Double> findMediumSalaryForEachDepartment(List<Employee> employeeList) {
        return employeeList.stream().collect(Collectors.
                groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> filterLinesThatConsistOfAlphabet(List<String> stringList, char[] alphabet){
        return stringList.stream().filter(str -> str.chars().allMatch(ch -> Arrays.toString(alphabet)
                .contains(String.valueOf((char) ch)))).sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<String> transformListOfIntToListOfBinaryString(List<Integer> integerList){
        return integerList.stream().map(Integer::toBinaryString).toList();
    }

    public static List<Integer> findAllPalindromeFromRange(int startNumber, int finishNumber){
        return IntStream.rangeClosed(startNumber, finishNumber).filter(num ->{
            String strNum = String.valueOf(num);
            String reversed = new StringBuilder(strNum).reverse().toString();
            return strNum.equals(reversed) && strNum.length() > 1;
        }).boxed().toList();
    }

    public static List<String> findAllSubstringPalindromeInString(String inputString) {
        return IntStream.range(0, inputString.length()).boxed().flatMap(start -> IntStream
                        .rangeClosed(start + 1, inputString.length()).mapToObj(end -> inputString.substring(start, end))
                                .filter(str -> str.length() > 1 && IntStream.range(0, str.length() / 2).allMatch(i ->
                                        str.charAt(i) == str.charAt(str.length() - 1 - i)))).distinct().toList();
    }

    public static List<Integer> findAGreatNumber(int startNumber, int finishNumber){
        return IntStream.rangeClosed(startNumber, finishNumber).filter(num -> IntStream.rangeClosed(1, num)
                .filter(x -> num % x == 0).sum() == 2 * num).boxed().collect(Collectors.toList());
    }
}
