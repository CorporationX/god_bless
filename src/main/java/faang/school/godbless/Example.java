package faang.school.godbless;

public class Example {
    public int[] reverse(int[] arr) {
        int[] result = new int[arr.length];
        int i = 0;
        int j = arr.length - 1;

        while (i <= arr.length - 1) {
            result[i] = arr[j];
            i++;
            j--;
        }

        return result;
    }
}
