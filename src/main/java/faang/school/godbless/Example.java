package faang.school.godbless;

public class Example {
    public int[] reverse(int[] arr) {
        int[] resultArr = new int[arr.length];
        int i = 0;
        int j = arr.length - 1;

        while (i <= arr.length - 1) {
            resultArr[i] = arr[j];
            i++;
            j--;
        }

        return resultArr;
    }
}
