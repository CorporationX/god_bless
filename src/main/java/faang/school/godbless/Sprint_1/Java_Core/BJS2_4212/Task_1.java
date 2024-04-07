//Развернитесь!
//Создать класс Example. В нём объявить метод, который принимает массив целых чисел в качестве параметра
//и называется reverse. Этот метод должен разворачивать переданный массив.
//Пример: nums = [1,2,3,4,5] → reverse(nums) → nums = [5,4,3,2,1].

package faang.school.godbless.Sprint_1.Java_Core.BJS2_4212;
public class Task_1 {
    public static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int num = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = num;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        reverse(nums);
        for (int arr : nums) {
            System.out.print(arr + "  ");
        }
    }
}
