package faang.school.godbless;

public class Example {

    /*
    Перебором
    Создаем новый пустой массив, счетчик counter и цикл for в обратном порядке
    записываем в новый массив числа из первого после записи инкрементируем счетчик counter
    возвращаем результат reversedNums
     */
    public static int[] reverse1(int[] nums){

        int[] reversedNums = new int[nums.length];
        int counter = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            reversedNums[counter] = nums[i];
            counter++;
        }
        return reversedNums;
    }

    /*
    Два указателя:
    Заводим временную переменную tmp
    В цикле for
    Первый элемент меняем с последним, второй с предпослдним
    и т.д. пока указатель не окажется в середине массива
     */

    public static int[] reverse2(int[] nums){

        int tmp;

        for (int i = 0; i < nums.length / 2; i++) {
            tmp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = tmp;
        }
        return nums;
    }

}
