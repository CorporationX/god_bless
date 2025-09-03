package school.faang.bjs2_85451_turnAround;

public class TurnAround {
    public static void reverse(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int start = 0, end = array.length - 1; start < end; start++, end--) {
            int temp = array[end];
            array[end] = array[start];
            array[start] = temp;
        }
    }
}
