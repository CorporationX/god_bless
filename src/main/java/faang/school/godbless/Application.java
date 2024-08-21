package faang.school.godbless;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Application {
    public static void main(String[] args) {
        System.out.println("God Bless!");
    }

    public static List<Integer> mapToInt(List<String> list){
        return list.stream().map(String::length).toList();
    }

    public static int findTheSmallestItemGreaterThan(List<Integer> list,int a){
        return list.stream().filter(b-> a<b).sorted().findFirst().get();
    }

    public static boolean checkIfAllItemsSatisfyCondition(List<String> list){
        return list.stream().allMatch(a-> a.startsWith("a"));
    }

    public static int countStringsStartingWith(List<String> list){
        return findStrings(list, Integer::sum, a-> a.startsWith("d"));
    }
    public static List<String> sortList(List<String> list){
        return list.stream().sorted((a,b)-> Integer.compare(a.length(),b.length())).toList();
    }

    public static List<String> filterBySubstrings(List<String> list){
        return list.stream().filter(a-> a.startsWith("do")).toList();
    }
    public static int findStrings(List<String> list, BiFunction<Integer, Integer, Integer> function,
                           Predicate<String> predicate) {
        return list.stream().filter(predicate).map(a->1).reduce(0, function::apply);
    }
    public static int findEvenNumbersSum(List<Integer> numbers){
        return find(numbers, (a, b) -> b + a, a->a%2 == 0);
    }

    public static int findMax(List<Integer> numbers){
        return find(numbers, (a, b) -> {return (a >= b) ? a : b;}, a->true);
    }
    public static int findAvarage(List<Integer> numbers){
        return find(numbers, Integer::sum, a->true)/numbers.size();
    }

    public static int find(List<Integer> list, BiFunction<Integer, Integer, Integer> function,
                           Predicate<Integer> predicate) {
        return list.stream().filter(predicate).reduce(0, function::apply);
    }
}