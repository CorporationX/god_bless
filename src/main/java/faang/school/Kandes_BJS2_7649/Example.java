package faang.school.Kandes_BJS2_7649;

public class Example {

    public static void reverse(int[] array) {
        // переменная для временного хранения значений
        int temp;

        // идем по половине массива тк каждую итерацию будем менять первое и противоположное значение
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            // вычитаем 1 тк индексация идет с нуля
            // вычитаем i чтобы брать противоположное значение списка
            // в случае с нечетным ко-вом эл-тов у какого то не будет пары
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}