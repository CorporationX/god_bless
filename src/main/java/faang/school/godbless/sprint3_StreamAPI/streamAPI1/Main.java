package faang.school.godbless.sprint3_StreamAPI.streamAPI1;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(2, 5, 6, 7, -2);
        int result = sum(list1);
        System.out.println(result);
//        int res = maxNum(new ArrayList<>());
        int res = maxNum(list1);
        System.out.println(res);
        OptionalDouble mediumNum = medium(list1);
        System.out.println(mediumNum);
        Optional<Integer> ints2 = numsInt(list1, 0);
        System.out.println(ints2);


        List<String> list2 = List.of("apple", "hey", "white", "hello");
//        List<String> list2 = List.of("good morning", "apple", "hey", "white", "hello");
        List<String> str1 = line(list2, "he");
        System.out.println(str1);
        List<String> str2 = strings(list2);
        System.out.println(str2);
        boolean str3 = predicate(str -> str.contains("e"), list2);
        System.out.println(str3);
        List<Integer> intss = ll(list2);
        System.out.println(intss);
    }

    public static int sum(List<Integer> listOfNumbers) {
        int results = listOfNumbers.stream().mapToInt(i -> i.intValue()).sum();
        return results;
    }

    public static Integer maxNum(List<Integer> listOfNums) {
        Optional<Integer> res = listOfNums.stream().max((s1, s2) -> s1 - s2);
        return res.orElse(0);
    }

    public static OptionalDouble medium(List<Integer> listOfNumber) {
        OptionalDouble medium = listOfNumber.stream().mapToInt(j -> j.intValue()).average();
        return medium;
    }

    public static List<String> line(List<String> listOfLine, String str) {
        List<String> lines = listOfLine.stream().filter(x -> x.contains(str)).toList();
        return lines;
    }

    public static List<String> strings(List<String> stringList) {
        List<String> list = stringList.stream().sorted((s1, s2) -> s1.length() - s2.length()).toList();
        return list;
    }

    public static boolean predicate(Predicate<String> predicate, List<String> listStr) {
        boolean listBoolean = listStr.stream().allMatch(predicate);
        return listBoolean;
    }

    public static Optional<Integer> numsInt(List<Integer> listOfMin, Integer integer) {
        Optional<Integer> numMin = listOfMin.stream().filter(s -> s > integer).min((s1, s2) -> s1 - s2);
        return numMin;
    }

    public static List<Integer> ll(List<String> str4) {
        List<Integer> ss = str4.stream().map(s -> s.length()).toList();
        return ss;
    }
}
