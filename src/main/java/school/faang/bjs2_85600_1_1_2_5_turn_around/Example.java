package school.faang.bjs2_85600_1_1_2_5_turn_around;

public class Example {

    public static void reverse(int[] array) {
        if (array.length <= 1) {
            return;
        }

        for (int l = 0, r = array.length - 1; l < r; l++, r--) {
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;
        }
    }

}
