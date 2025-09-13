package school.faang.streamapi_1_bjs_2_88179;


import java.util.List;

public class OperatorMain {
    public static void main(String[] args) {

        List<Integer> number = List.of(1, 2, 3, 10, 16);

        List<String> strings = List.of("aaa", "dsaerg", "aaa", "ihebn", "aaa");

        System.out.println("Сумма" + ListOperations.sumNumbers(number));

        System.out.println("Самое большое число" + ListOperations.maxNumber(number));

        System.out.println("Среднее значение " + ListOperations.findAverage(number));

        System.out.println("Колличество строк с таким символом " + ListOperations.findCharStrings(strings, 'a'));

        System.out.println("Искомые строки " + ListOperations.findNeedStrings(strings, "aaa"));

        System.out.println("Сортировка по длине строк " + ListOperations.sortLength(strings));

        System.out.println("Все четные числа? " + ListOperations.allMatchCondition(number, n -> n % 2 == 0));

        System.out.println("Минимальное число, которое больше 6 " + ListOperations.findMinGreaterThan(number, 6));

        System.out.println("Список длин строк изночального списка " + ListOperations.convertToLengths(strings));
    }
}
