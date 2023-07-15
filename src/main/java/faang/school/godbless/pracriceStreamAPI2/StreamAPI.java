package faang.school.godbless.pracriceStreamAPI2;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamAPI {
    public static Set<List<Integer>> setOfUniqCouplesOfNumbers(List<Integer> numbersList, Integer number) { //1
        return numbersList.stream()
                .filter(nl -> numbersList.contains(number - nl)) // непон как через set сделать
                .map(n -> Arrays.asList(n, number - n))
                .peek(Collections::sort).collect(Collectors.toSet());
    }

    public static List<String> sortCountriesAlphabetically(Map<String, String> countriesAndCapitals) { //2
        return countriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .map(Map.Entry::getValue).toList();
    }

    public static List<String> sortLinesThatStartsWithLetter(List<String> lines, char letter) { //3
        return lines.stream()
                .filter(l -> l.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());


    }
    public static Map<String, Double> creatMapWithAverageSalary(List<Employee> list) { // отдел, сред зарплата // 5
        return list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<String> sortedLinesByLetters(List<String> lines, String alphabet) { //6
        return lines.stream()
                .filter(str -> str.replaceAll("\\s+", "").toLowerCase().matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> intToString(List<Integer> numbers) { //7
        return numbers.stream()
                .map(Integer::toBinaryString).collect(Collectors.toList());
    }

    public static List<Integer> findPalindromes(Integer head, Integer tail) { //8
        List<Integer> listOfNumbers = IntStream.range(head, tail+1)
                .filter(n -> {
                        String str = Integer.toString(n);
                        return str.equals(new StringBuilder(str).reverse().toString() );
                }).boxed()
                .collect(Collectors.toList());
        return listOfNumbers;
    }

}
