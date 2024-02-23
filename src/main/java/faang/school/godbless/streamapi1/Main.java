package faang.school.godbless.streamapi1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println("Сумма четных чисел: " + StreamStaticMethod.sumNumber(numbers));
        System.out.println("Максимальный элемент в списке: " + StreamStaticMethod.maxNumber(numbers));
        System.out.println("Среднее значение чисел в списке: " + StreamStaticMethod.averageNumbers(numbers));
        System.out.println("Наименьший элемент в списке: " + StreamStaticMethod.findSmallestNumbers(numbers, 5));

        List<String> strings = List.of("Hi","ok", "five","fff","hello", "world");
        System.out.println("Количество строк, начинающихся с определённого символа: " + StreamStaticMethod.findNumString(strings, 'f'));
        System.out.println("Список строк, которые содержат определенную подстроку: " + StreamStaticMethod.filterListRows(strings, "he"));
        System.out.println("Список строк отсортирован по длине: " + StreamStaticMethod.sortStringsByLength(strings));
        System.out.println("Все ли элементы списка удовлетворяют определённому условию: " + StreamStaticMethod.checkCondition(strings, s -> s.length() > 3));
        System.out.println("Преобразовали список строк в список их длин: " + StreamStaticMethod.convertListStringsLength(strings));
    }
}


