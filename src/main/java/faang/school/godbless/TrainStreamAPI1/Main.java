package faang.school.godbless.TrainStreamAPI1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 10, 7, 9);
        List<String> strings = Arrays.asList("Hello", "house", "java", "Predicate", "stream", "api", "close");
        int sumNums = StreamMethods.sumOfEvenNumbers(numbers);
        System.out.println("Сумма четных чисел = " + sumNums);

        int maxElement = StreamMethods.maxElement(numbers);
        System.out.println("Максимальный элемент в списке = " + maxElement);

        double averageNumbers = StreamMethods.averageNumbers(numbers);
        System.out.println("Среднее значение числа в списке = " + averageNumbers);

        int startWithLetter = StreamMethods.startWithLetter('h', strings);
        System.out.println(startWithLetter + " слов начинается с символа"); //а как передать символ сюда - не знаю


        List<String> stringFilter = StreamMethods.stringFilter("lo", strings);
        System.out.println(stringFilter.toString());

        boolean check = StreamMethods.check(strings);
        System.out.println("Все ли элементы удовлетворяют условию? " + check);

        int minElement = StreamMethods.minElementMoreValue(5, numbers);
        System.out.println("Минимальный элемент из оставшихся " + minElement);

        List<Integer> listByStringLenght = StreamMethods.listByStringLenght(strings);
        System.out.println("Список длин слов " + listByStringLenght);


    }
}
