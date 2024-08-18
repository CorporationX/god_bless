package faang.school.godbless.task.stream.api.first.prcatice;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Список цифр
        var numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        // Найти сумму четных чисел
        int sumEven = numbers.stream()
                .filter(n -> (n % 2) == 0).reduce(0, (n1, n2) -> n1 + n2);
        System.out.println("Сумма четных чисел: " + sumEven);

        // Найти максимальный элемент в списке чисел
        int maxNum = numbers.stream().mapToInt(Integer::intValue).max().getAsInt();
        System.out.println("Максимально число из списка: " + maxNum);

        // Найти среднее значение чисел в списке
        double middleValue = numbers.stream().mapToInt(Integer::intValue).average().getAsDouble();
        System.out.println("Среднее значение из списка: " + middleValue);

        // Список слов
        var words = List.of("apple", "pineapple", "mango", "pepper", "magic", "piper");

        // Найти количество строк, начинающихся с определённого символа в списке строк
        String letter = "p";
        long numberOfWords = words.stream().filter(word -> word.startsWith(letter)).count();
        System.out.println("Количество слов на буку '%s': %s".formatted(letter, numberOfWords));

        // Отфильтровать список строк и оставить только те, которые содержат определенную подстроку
    }
}
