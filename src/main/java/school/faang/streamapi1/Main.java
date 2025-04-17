package school.faang.streamapi1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("сумма четных чисел1: " + Operations.sumEvenNumbers(List.of(1, 3, -4, 9, -8)));
        System.out.println("сумма четных чисел2: " + Operations.sumEvenNumbers(List.of(1, 3, 9, -9)));

        System.out.println("максимальный элемент в списке: " + Operations.maxElement(List.of(1, 6, 3, 7, 0, 19)));

        System.out.println("среднее значение чисел: " + Operations.averageValueNumbers(List.of(3, 5, 6)));

        System.out.println("количество строк, начинающихся с определённого символа: " +
                Operations.numbersLinesStartingCharacter(List.of("str", "frg", "abc", "fge"), 'f'));
        System.out.println("количество строк, начинающихся с определённого символа: " +
                Operations.numbersLinesStartingCharacter(List.of("str"), 'f'));

        System.out.println("Отфильтровать список строк и оставить только те, которые содержат определённую подстроку: "
                + Operations.filterListRows(List.of("hello world", "hello freand", "by ghj",
                        "I do not know English, it hurts me"), "hello"));


        System.out.println("Отсортировать список строк по длине: " +
                Operations.sortLineStringsByLength(List.of("abcd", "ab", "b", "abc", "a")));

        System.out.println("все ли элементы списка удовлетворяют определённому условию: " +
                Operations.isListCondition(List.of(3, 5, 7, 9), num -> num > 0));
        System.out.println("все ли элементы списка удовлетворяют определённому условию: " +
                Operations.isListCondition(List.of(3, 5, 7, 9, -2), num -> num > 0));

        System.out.println("наименьший элемент в списке, который больше заданного числа: " +
                Operations.smallestItemThatLargerSpecified(List.of(17, 19, 4, 28, 7, 10), 11));

        System.out.println("список строк в список их длин: " +
                Operations.listStringsToTheirLengths(List.of("str", "qwerty", "a", "sdfgzxcv")));
    }
}
