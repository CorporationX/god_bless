package faang.school.godbless;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UtilStreamSecond {

    //№1
    public static Map<Integer, Integer> FindAllUniquePairsNumbers(List<Integer> numbers, int sum) {
        Set<Integer> intSet = new HashSet<>();
        return numbers.stream().distinct().filter(i ->
               numbers.contains(sum - i) &&  !intSet.contains(i)).collect(Collectors.
                toMap(Function.identity(), i -> {
                    intSet.add(sum - i);
                    return sum - i;
                }));
    }
    //№2
    public static List<String> sortCountryGetCapitals(Map<String, String> countryAndCapitals) {
        return countryAndCapitals.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();
    }
    //№3
    public static List<String> filterStrWithStartingSpecChar(List<String> ListStr, char ch) {
       return ListStr.stream().filter(str ->str.toLowerCase().startsWith(String.valueOf(ch).toLowerCase()))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
    //№4
    public static Set<String> findMutualFriends(Map<String, List<String>> people) {
        return    people.entrySet().stream()
                .flatMap(person -> people.entrySet().stream()
                        .filter(thisPerson -> !thisPerson.getKey().equals(person.getKey()))
                        .filter(notFriends -> person.getValue().contains(notFriends.getKey()))
                        .filter(commonFriendPerson -> person.getValue().stream()
                                .anyMatch(friend -> commonFriendPerson.getValue().contains(friend)))
                        .map(otherPerson -> person.getKey() + " " + otherPerson.getKey())
                ).collect(Collectors.toSet());
    }
    //№5
    public static Map<String, Double> getAverageSalary(List<Employee> employees) {
        return employees.stream().collect(
                Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                )
        );
    }
    //№6
    public static List<String> getFilterStrContentLettersAndSortByLength(List<String> listStr, String alphabet) {
        return listStr.stream()
                .filter(str -> str.chars()
                        .allMatch(ch -> alphabet.contains(String.valueOf((char) ch))
                        )).toList();
    }
    //№7
    public static List<String> getConvertIntToStrWrittenBinary(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }
    //№8
    public static List<Integer> findPalindromeNumbers(int beginNum, int endNum) {
        return IntStream.rangeClosed(beginNum, endNum)
                .filter(num -> Integer.toString(num).equals(
                        new StringBuilder(Integer.toString(num)).reverse().toString()))
                .boxed().toList();
    }

}
