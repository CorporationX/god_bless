package faang.school.godbless;
import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = console.nextInt();
        }
        System.out.println(array);

        reverse(array);
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
