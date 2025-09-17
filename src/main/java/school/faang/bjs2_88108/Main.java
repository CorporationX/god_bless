package school.faang.bjs2_88108;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> someNumbers = List.of(23, 90, 2, 11, 7, 34, 43, 35, 77, 42, 188, 220, 21, 7, 9);
        System.out.println("* Сумма всех четных чисел: " + ListOperations.findSumOfEvenNumbers(someNumbers));
        System.out.println("* Максимальное число: " + ListOperations.findMaxNumber(someNumbers));
        System.out.println("* Среднее арифметическое значение: " + ListOperations.findAverageValue(someNumbers));
        System.out.printf("* Минимальное число %d после %d\n",
                ListOperations.findMinGreaterThan(someNumbers, 75), 75);

        System.out.println();

        List<String> someAdjectives = List.of(
                "Сомнительный", "Драгоценный", "Сокрушительный", "Прозрачный",
                "Ароматный", "Блистающий", "Расколотый", "Вселяющий",
                "Разработанный", "Разрушенный", "Ласковый", "Надежный",
                "Сомнительный", "Стирающий", "Шикарный", "Хрупкий"
        );
        System.out.printf("* Найдено %d слов, начинающихся с буквы %c\n",
                ListOperations.countStringsContainingChar(someAdjectives, 'Р'), 'Р');

        System.out.printf("* Слова %s содержат подстроку %s\n",
                ListOperations.findStringsContainingSubstring(someAdjectives, "Ра"), "Ра");

        System.out.println("* Слова отсортированы по длине:");
        ListOperations.sortStringsByLength(someAdjectives).forEach(System.out::println);
        System.out.println();

        Predicate<String> doAllContain = adjective -> adjective.contains("й");
        if (ListOperations.areAllStringsEqual(someAdjectives, doAllContain)) {
            System.out.println("* Все элементы в списке содержат \"й\"");
        } else {
            System.out.println("* Ни один элемент в списке не имеет \"й\"");
        }

        List<Integer> adjectivesLengths = ListOperations.turnToLengthSize(someAdjectives);
        System.out.println("* Список прилагательных преобразован в список их длин:");
        System.out.println(adjectivesLengths);
    }
}
