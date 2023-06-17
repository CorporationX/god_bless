package faang.school.godbless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();

        int num;
        while (console.hasNextInt()){
            num = console.nextInt();
            nums.add(num);
        }

        int[] array = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            array[i] = nums.get(i);
        }

        System.out.println(Arrays.toString(array));

        reverse(array);
        System.out.println(Arrays.toString(array));
    }

    public static int[] reverse(int[] array) {

        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}
//
//    public static void main(String[] args) {
//        Scanner console = new Scanner(System.in);
//        int[] array = new int[array.length];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = console.nextInt();
//        }
//        System.out.println(Arrays.toString(array));
//
//        reverse(array);
//        System.out.println(Arrays.toString(array));
//    }
