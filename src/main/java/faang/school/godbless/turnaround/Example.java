package faang.school.godbless.turnaround;


public class Example {
    public static int[] reverse (int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[arr.length-1-i];
        }
        return res;
    }

    public static void main(String[] args) {
        reverse(new int[] {1,2,3,4});
    }
}
