package school.faang.bjs2_85451_turnAround;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Создаем наш массив
        int[] arrayReal = {1, 2, 3, 4, 5, 6, 7};
        // Печатаем исходный массив
        System.out.println("Исходный массив: " + Arrays.toString(arrayReal));
        //Вызываем статический метод reverse класса TurnAround для зеркального отражения элементов массива arrayReal
        TurnAround.reverse(arrayReal);
        // Печатаем перевернутый массив
        System.out.println("Перевернутый массив: " + Arrays.toString(arrayReal));
    }
}
