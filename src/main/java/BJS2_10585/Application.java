package BJS2_10585;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<Integer> listNumbers = List.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println("Sum of Event numbers: " + sumOfEventNumbers(listNumbers));
        System.out.println("Max number: " + maxNumber(listNumbers));
        System.out.println("The average " + averageNumber(listNumbers));

        List<String> names = List.of("Vitalij","Veronika", "Maks", "Pavel","Pavel");
        Character symbol = 'V';
        int element = 8;

        quantityOfLines(names, symbol);
        List<String> name = correctedList(names);
        name.forEach(System.out::println);
        System.out.println("List sorted " + sortedList(names));
        System.out.println("check for condition: " + isTrueForEach(name, s -> s.length() < 6));
        System.out.println("Smallest element in list: " + smallestElementInList(listNumbers,element));
        System.out.println(convertStringToInteger(names));

    }

    public static int sumOfEventNumbers(List<Integer> listNumbers){
        return listNumbers.stream().filter( n -> n % 2 == 0).
                reduce(0, Integer::sum);
    }

    public static int maxNumber(List<Integer> listNumbers){

        return listNumbers.stream().max(Integer::compare).orElseThrow();
    }

    public static double averageNumber(List<Integer> listNumbers){
        return listNumbers.stream().mapToInt(Integer::intValue).average().orElseThrow();
    }

    public static void quantityOfLines(List<String> names, Character s){
         names.stream().filter(n -> n.charAt(0) == s )
                 .forEach(n -> System.out.println(n +" - "+ n.length()));
    }

    public static List<String> correctedList(List<String> names){
        return names.stream().filter(str -> str.matches("Pavel"))
                .collect(Collectors.toList());
    }

    public static List<String> sortedList(List<String> names){
        return names.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean isTrueForEach(List<String> strings, Predicate<String> condition) {
        return strings.stream().allMatch(condition);
    }

    public static int  smallestElementInList(List<Integer> listNumbers, int element){
       return  listNumbers.stream()
                .mapToInt(e -> e)
                .filter(e -> e > element)
                .min().orElseThrow();
    }

    public static List<Integer> convertStringToInteger(List<String> names){
       return names.stream().map(String::length).toList();
    }
}
