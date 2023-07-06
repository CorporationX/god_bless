package faang.school.godbless.sprint_3.StreamAPI_1;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 3, 34, 56, 66, 22, 2, 3, 54);
        List<String> strings = List.of("human", "man", "women", "dog", "hotdog");
        System.out.println(Main.sumOfEvenNumbers(numbers));
        System.out.println(Main.maxElement(numbers));
        System.out.println(Main.averageValue(numbers));
        System.out.println(Main.startCharacter(strings, 'h'));
        System.out.println(Main.specificCharacter(strings, "man"));
    }

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(number -> number % 2 == 0).reduce(0, Integer::sum);
    }

    public static int maxElement(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).orElse(0);
    }

    public static int averageValue(List<Integer> numbers) {
        return (int) numbers.stream().mapToInt(Integer::intValue).average().orElse(0);//метод map
    }

    public static long startCharacter(List<String> strings, Character character) {
        return strings.stream().filter(string -> string.startsWith(String.valueOf(character))).count();//почему count/long?
    }

    public static List<String> specificCharacter(List<String> strings, String substring) {
        return strings.stream().filter(s -> s.contains(substring)).toList();
    }

    public static List<String> sortLength(List<String> strings) {
        return strings.stream().sorted(String::compareTo).toList();//(s1, s2) ->s1.compareTo(s2))
    }

    public static <T> boolean checkElements(List<T> list, Predicate<T> predicate) {
        return list.stream().allMatch(predicate);
    }
    public static int findMin(List<Integer> list, int n){
        return list.stream().filter(element -> element > n).min(Integer::compareTo).orElse(Integer.MIN_VALUE);
    }
    public static List<Integer> mapLength(List<String> strings){
        return strings.stream().map(String::length).toList();
    }
}


/*Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int;

Найти максимальный элемент в списке чисел;

Найти среднее значение чисел в списке;

Найти количество строк, начинающихся с определённого символа в списке строк;

Отфильтровать список строк и оставить только те, которые содержат определенную подстроку;

Отсортировать список строк по длине;

Проверить, все ли элементы списка удовлетворяют определённому условию;

Найти наименьший элемент в списке, который больше заданного числа;

Преобразовать список строк в список их длин.*/