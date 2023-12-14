package faang.school.godbless.TrainStreamAPI1;

import java.util.List;

public class StreamMethods {

    // Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int;
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        int sumNumbers = numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        return sumNumbers;
    }

    //Найти максимальный элемент в списке чисел
    public static int maxElement(List<Integer> numbers) {
        int maxElement = numbers.stream()
                .max((a, b) -> a.compareTo(b))
                .orElse(0);
        return maxElement;
    }

    //Найти среднее значение чисел в списке
    public static double averageNumbers(List<Integer> numbers) {
        double averageNumbers = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
        return averageNumbers;
    }

    //Найти количество строк, начинающихся с определённого символа в списке строк
    public static int startWithLetter(Character character, List<String> stringList) {
        int result = (int) stringList.stream()
                .map(String::toLowerCase)
                .filter(string -> string.startsWith(String.valueOf(character)))
                .count();
        return result;
    }

    //Отфильтровать список строк и оставить только те, которые содержат определенную подстроку
    public static List<String> stringFilter(String string, List<String> stringList) {
        List<String> strings = stringList.stream()
                .filter(word -> word.contains(string))
                .toList();
        return strings;
    }

    //Отсортировать список строк по длине
    public static List<String> sortByLenght(List<String> stringList) {
        List<String> sort = stringList.stream()
                .sorted((word1, word2) -> word1.length())
                .toList();
        return sort;
    }

    //Проверить, все ли элементы списка удовлетворяют определённому условию
    public static boolean check(List<String> stringList) {
        boolean check = stringList.stream()
                .allMatch(string -> string.length() > 2);
        return check;
    }

    //Найти наименьший элемент в списке, который больше заданного числа
    public static int minElementMoreValue(Integer nums, List<Integer> integers) {
        int result = integers.stream()
                .filter(num -> nums < num)
                .min(Integer::compareTo)
                .orElse(0);
        return result;
    }

    //Преобразовать список строк в список их длин
    public static List<Integer> listByStringLenght(List<String> stringList) {
        List<Integer> wordLenght = stringList.stream()
                .map(string -> string.length())
                .toList();
        return wordLenght ;
    }
}
