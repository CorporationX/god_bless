package school.faang;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        // Печатаем исходный массив
        System.out.println("Исходный массив:");
        printArray(nums);

        // Разворачиваем массив
        reverse(nums);

        // Печатаем развёрнутый массив
        System.out.println("Развёрнутый массив:");
        printArray(nums);
    }
}