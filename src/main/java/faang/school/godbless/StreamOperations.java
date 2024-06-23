package faang.school.godbless;

import java.util.*;

public class StreamOperations {
    public static int summEven(List<Integer> list) {
        return list.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
    }
    public static int findMaxInt(List<Integer> list) {
        return list.stream().max(Comparator.naturalOrder()).orElse(0);
    }
    //Найти среднее значение чисел в списке;
    public static double findAverage(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).average().orElse(0);
    }
        /*OptionalDouble max = list.stream().mapToInt(Integer::intValue).average();
        if (max.isPresent()) {
            return max.getAsDouble();
        } else {
            return 0;
        }*/
    //Найти количество строк, начинающихся с определённого символа в списке строк;
    public static long findQuantityStringsFromSymbol(List<String> list, String symbol) {
        return list.stream().filter(name -> name.startsWith(symbol)).count();
    }
    //Отфильтровать список строк и оставить только те, которые содержат определенную подстроку;
    public static List<String> findStringsWithSubstring(List<String> list, String substring) {
        return list.stream().filter(name -> name.contains(substring)).toList();
    }
    //Отсортировать список строк по длине;
    public static List<String> sortStrings(List<String> list) {
        return list.stream().sorted((s1,s2) -> s1.length() - s2.length()).toList();
    }
    //Проверить, все ли элементы списка удовлетворяют определённому условию;
    public static boolean findIfMoreThen(List<Integer> list, int number) {
        return list.stream().allMatch(intInList -> intInList > number);
    }
    //Найти наименьший элемент в списке, который больше заданного числа;
    public static int findMinMoreThen(List<Integer> list, int number) {
        return list.stream().filter(intInList -> intInList > number).min(Comparator.naturalOrder()).orElse(0);
    }
    //Преобразовать список строк в список их длин.
    public static List<Integer> makeStringsLengths(List<String> list) {
        return list.stream().map(String::length).toList();
    }




    public static void main(String[] args) {
        List<Integer> listToStream = new ArrayList<Integer>();
        listToStream.add(1);
        listToStream.add(5);
        listToStream.add(2);
        listToStream.add(4);
        listToStream.add(16);
        System.out.println(summEven(listToStream));
        System.out.println(findMaxInt(listToStream));
        System.out.println(findAverage(listToStream));

        List<String> Strings = new ArrayList<String>();
        Strings.add("zzzzpp000000000");
        Strings.add("zzzzppp");
        Strings.add("222ffzppp");
        Strings.add("222zzpff");
        Strings.add("122zzzppp9999");

        System.out.println(findQuantityStringsFromSymbol(Strings,"1"));
        System.out.println(findStringsWithSubstring(Strings,"ff"));
        List<String> SortedList = new ArrayList<>(0);
        SortedList = sortStrings(Strings);
        SortedList.stream().forEach(string -> System.out.println(string));

        System.out.println(findIfMoreThen(listToStream,0));
        System.out.println(findIfMoreThen(listToStream,20));

        System.out.println(findMinMoreThen(listToStream,1));
        System.out.println(findMinMoreThen(listToStream,4));

        System.out.println(makeStringsLengths(Strings));
    }
}
