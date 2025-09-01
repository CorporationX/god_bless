package school.faang.bjs2_85468;

public class Example {
    protected int[] reverse(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return arr;
        }


        int tmp;
        for (int i = 0; i < arr.length / 2; i++) {
            tmp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = tmp;
        }

        return arr;
    }
}
