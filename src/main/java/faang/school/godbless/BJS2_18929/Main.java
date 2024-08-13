package faang.school.godbless.BJS2_18929;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Создаем объект класса Example
        Example example = new Example();

        // Инициализируем массив целых чисел
        int[] nums = {1, 2, 3, 4, 5};

        // Выводим массив до разворота
        System.out.println("Before reverse: " + Arrays.toString(nums));

        // Разворачиваем массив
        example.reverse(nums);

        // Выводим массив после разворота
        System.out.println("After reverse: " + Arrays.toString(nums));
    }
}