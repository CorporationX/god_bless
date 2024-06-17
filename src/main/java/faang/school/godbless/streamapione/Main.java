package faang.school.godbless.streamapione;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8);
        System.out.println(evenNumSum(numbers));
        System.out.println(maxNumber(numbers));
        System.out.println(average(numbers));
        List<String> strings = List.of("BMW","Mercedes","Audi");
        System.out.println(beginsWith(strings,'B'));
        System.out.println(matchesSubstring(List.of("Audi","Alfa romeo"),"Aud").toString());
        System.out.println(sortByStringLength(List.of("ab","abcdef","abcde","a")).toString());
        System.out.println(matchesCondition(List.of(1,2,3),(el)->el>1));
        System.out.println(moreThanMax(List.of(1,2,3,4,5,6,7,8),4));
        System.out.println(lengthList(List.of("Ali","al","abcd")).toString());
    }
    public static int evenNumSum(List<Integer> list) {
        int res = list.stream().filter(el->el%2==0).mapToInt(num->num).sum();
        return res;
    }
    public static int maxNumber(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).max().orElse(0);
    }
    public static double average(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
    }
    public static int beginsWith(List<String> strings,Character ch) {
        Predicate<String> filterFn = (el)->el.charAt(0)==ch;
        return strings.stream().filter(filterFn).toList().size();
    }
    public static List<String> matchesSubstring(List<String> strings,String substring) {
        return strings.stream().filter(el->el.contains(substring)).toList();
    }
    public static List<Integer> sortByStringLength(List<String> strings) {
        return strings.stream().map(String::length).sorted(Comparator.naturalOrder()).toList();
    }
    public static <T> boolean matchesCondition(List<T> arr,Predicate<T> cond) {
        return arr.stream().allMatch(cond);
    }
    public static Integer moreThanMax(List<Integer> ints,Integer num) {
        return ints.stream().filter(el->el>num).min(Comparator.naturalOrder()).orElse(0);
    }
    public static List<Integer> lengthList(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
