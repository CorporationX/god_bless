package faang.school.godbless.BJS2_5139;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<String> strings = new ArrayList<>(List.of("site", "stop", "win", "away", "sit"));

        System.out.println("Сумма чётных чисел: " + StreamAPIService.findSumOfEvenNumbers(numbers));
        System.out.println("Максимальное число: " + StreamAPIService.findMaxNumber(numbers));
        System.out.println("Среднее значение: " + StreamAPIService.findAverageValueOfNumbers(numbers));
        System.out.println("Количество строк, которые начинаются с 's' : " + StreamAPIService
                .countStringStartingWithChar('s', strings));
        System.out.println("Слова содержащие подстроку: " + StreamAPIService.filterStringThatContainSubstring("si", strings));
        System.out.println("Отсортированный список: " + StreamAPIService.sortStringByLength(strings));
        System.out.println("Элементы удовлетворяющие условию:" + StreamAPIService.checkStringForMaxLength(3, strings));
        System.out.println("Минимальный элемент который больше 2: " + StreamAPIService.findMinElementThatMoreNumber(2, numbers));
        System.out.println("Длина строк:" + StreamAPIService.convertStringToStringLength(strings));
    }
}
