package faang.school.godbless.core_split;

public class Example {

    public static int[] reverse(int[] arr) {
        int[] reverseArr = new int[arr.length];

        for (int i=0; i<arr.length; i++) {
            reverseArr[i] = arr[arr.length-i-1];
        }

        return reverseArr;
    }
}
