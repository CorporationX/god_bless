package faang.school.godbless.Reverse;

public class Example {
    public static int[] reverse(int[] num) {
        if (num == null)
            return new int[]{};
        int i = 0;
        int j = num.length - 1;

        while (i < j) {
            swap(num, i, j);
            i++;
            j--;
        }
        return num;
    }

    private static void swap(int[] num, int left, int right) {
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }
}
