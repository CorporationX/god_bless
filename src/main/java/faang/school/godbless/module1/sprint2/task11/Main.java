package faang.school.godbless.module1.sprint2.task11;


import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        List<String> stringsList = List.of("hello", "hell", "yo", "breaking", "two");
        System.out.println(sumList(integerList));
        System.out.println(maxInList(integerList));
        System.out.println(middleValueOfList(integerList));
        System.out.println(countOfRowsWithSymbol(stringsList));
        System.out.println(filterListByContains(stringsList));
        System.out.println(filterListByLength(stringsList));
        System.out.println(checkListOfStringByCondition(stringsList));
        System.out.println(checkMinValueBiggestByCondition(integerList));
        System.out.println(convertListOfStringForIntegerByLength(stringsList));
    }

    public static int sumList(List<Integer> integerList) {
        return integerList.stream()
                .reduce(0, Integer::sum);
    }

    public static int maxInList(List<Integer> integerList) {
        return integerList.stream()
                .max(Comparator.comparingInt(l -> l))
                .orElse(0);
    }

    public static int middleValueOfList(List<Integer> integerList) {
        return integerList.stream()
                .reduce(0, Integer::sum) / integerList.size();
    }

    public static int countOfRowsWithSymbol(List<String> strings) {
        return (int) strings.stream()
                .filter(l -> l.startsWith("h"))
                .count();
    }

    public static List<String> filterListByContains(List<String> strings) {
        return strings.stream()
                .filter(l -> l.contains("el"))
                .toList();

    }

    public static List<String> filterListByLength(List<String> strings){
        return strings.stream()
                .sorted()
                .toList();
    }

    public static boolean checkListOfStringByCondition(List<String> strings){
        return strings.stream()
                .allMatch(l -> l.length() > 3);
    }

    public static int checkMinValueBiggestByCondition(List<Integer> integerList){
        return integerList.stream()
                .filter(l -> l > 3)
                .min(Integer::compareTo).orElse(0);
    }

    public static List<Integer> convertListOfStringForIntegerByLength(List<String> strings){
        return strings.stream()
                .map(String::length)
                .toList();
    }


}
