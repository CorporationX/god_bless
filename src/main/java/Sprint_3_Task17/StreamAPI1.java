package Sprint_3_Task17;

import java.util.Comparator;
import java.util.List;

public class StreamAPI1 {
    public static int sumOfEvenNumbers(List<Integer> listNumbers) {
//        Найти сумму четных чисел в списке
        return listNumbers.stream()
                .filter(a -> a % 2 == 0)
                .mapToInt(a -> a).sum();
    }

    public static int maxNumbers(List<Integer> listNumbers) {
//        Найти максимальный элемент в списке чисел
        return listNumbers.stream()
                .filter(a -> a % 2 == 0)
                .mapToInt(a -> a)
                .max()
                .orElse(0);
    }

    public static double averageValue(List<Integer> listNumbers) {
//    Найти среднее значение чисел в списке
        return listNumbers.stream()
                .mapToInt(a -> a)
                .average()
                .orElse(0);
    }

    public static List<String> stringSearch(List<String> listString) {
//    Найти количество строк, начинающихся с определённого символа в списке строк;
        return listString.stream()
                .filter(s -> s.startsWith("N"))
                .toList();
    }

    public static List<String> filterTheListOfStrings(List<String> listString) {
//    Отфильтровать список строк и оставить только те, которые содержат определенную подстроку;
        return listString.stream()
                .filter(s -> s.contains("a"))
                .toList();
    }

    public static List<String> lineLength(List<String> listString) {
//    Отсортировать список строк по длине;
        return listString.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean checkingListElements(List<String> listString) {
//    Проверить, все ли элементы списка удовлетворяют определённому условию;
        return listString.stream()
                .allMatch(s -> s.length() > 5);
    }

    public static int findTheSmallestElementInAList(List<Integer> listNumbers) {
//    Найти наименьший элемент в списке, который больше заданного числа;
        return listNumbers.stream()
                .filter(s -> s > 3)
                .mapToInt(s -> s)
                .min().orElse(0);
    }

    public static List<Integer> convertListLengths(List<String> listString) {
//    Преобразовать список строк в список их длин.
        return listString.stream()
                .map(String::length)
                .toList();
    }

    public static void main(String[] args) {
        List<Integer> listNumber = List.of(1, 2, 3, 4, 5, 6);
        List<String> listString = List.of("3", "Nikita", "Inna", "Vlad");
        System.out.println(sumOfEvenNumbers(listNumber));
        System.out.println(maxNumbers(listNumber));
        System.out.println(averageValue(listNumber));
        System.out.println(stringSearch(listString));
        System.out.println(filterTheListOfStrings(listString));
        System.out.println(lineLength(listString));
        System.out.println(checkingListElements(listString));
        System.out.println(findTheSmallestElementInAList(listNumber));
        System.out.println(convertListLengths(listString));
    }
}
