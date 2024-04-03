package StreamAPI1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void sum(List<Integer> list){ // Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int;
        int sum = list.stream()
                .reduce(0,(sum2, number) -> sum2 + number);

        System.out.println(sum);
    }

    public static void findMax(List<Integer> list){ // Найти максимальный элемент в списке чисел;
        int biggest = list.stream()
                .max((s1, s2) -> s1 - s2)
                .orElse(0);

        System.out.println(biggest);
    }

    public static void findMid(List<Integer> list){ // Найти среднее значение чисел в списке;
        int mid = list.stream()
                .reduce(0, (sum, number) -> sum + number);

        System.out.println(mid/list.size());
    }

    public static void findString(List<String> list){ // Найти количество строк, начинающихся с определённого символа в списке строк;
        Stream<String> resultStream = list.stream().
                filter(need -> need.startsWith("П"));
        List<String> resultList = resultStream.collect(Collectors.toList());

        System.out.println(resultList);
    }

    public static void filterStrings(List<String> list, String substring) { // Отфильтровать список строк и оставить только те, которые содержат определенную подстроку;
        List<String> result = list.stream()
                .filter(str -> str.contains(substring))
                .collect(Collectors.toList());

        System.out.println(result);
    }

    public static void filterStringByLength(List<String> list){ // Отсортировать список строк по длине;
        Stream<String> result = list.stream()
                .sorted((a , b) -> a.length() - b.length());
        List<String> resultList = result.collect(Collectors.toList());

        System.out.println(resultList);
    }

    public static void check(List<String> list){ // Проверить, все ли элементы списка удовлетворяют определённому условию;
        boolean check = list.stream()
                .allMatch(str -> str.length() > 3);

        System.out.println(check);
    }

    public static void smallest(List<Integer> list, int numb){ // Найти наименьший элемент в списке, который больше заданного числа;
        int smallest = list.stream()
                .filter(element -> element > numb)
                .min(Integer::compareTo).orElse(0);

        System.out.println(smallest);
    }

    public static void last(List<String> list){ // Преобразовать список строк в список их длин.
        List<Integer> result = list.stream()
                .peek(element -> element.length())
                .map(String::length)
                .collect(Collectors.toList());


       System.out.println(result);
    }

    public static void main(String args[]){
        List<Integer> list = Arrays.asList(4,2,6,10,8);
        List<String> list2 = Arrays.asList("Как дела", "Проверка", "Привет", "Пока", "Мяу");
        sum(list);
        findMax(list);
        findMid(list);
        findString(list2);
        filterStrings(list2, "Пр");
        filterStringByLength(list2);
        check(list2);
        smallest(list, 0);
        last(list2);
    }
}
