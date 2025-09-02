package school.faang.bjs2_85451_turnAround;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Создаем наш массив
        int[] arrayReal = {1, 2, 3, 4, 5, 6, 7};
        // Создаем пустой объект класса TurnAround (Пустой потому что у него нет конструктора)
        TurnAround turnAround = new TurnAround();
        //Вызываем метод reverse объекта turnAround для зеркального отражения элементов массива arrayReal
        int[] arrayRealReverse = turnAround.reverse(arrayReal);
        // Проверяем
        System.out.println("Исходный массив: " + Arrays.toString(arrayReal));
        System.out.println("Перевернутый массив: " + Arrays.toString(arrayRealReverse));



    }
}
