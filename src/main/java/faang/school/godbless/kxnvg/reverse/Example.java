package faang.school.godbless.kxnvg.reverse;

public class Example {

    public static int[] reverse(int[] arr) {
        int[] resultArray = new int[arr.length];

        if (arr == null) {
            throw new NullPointerException("Массив не должен быть null");
        } else if (arr.length == 0 || arr.length == 1) {
            return arr;
        }

        int count = arr.length - 1;
        for (Integer value : arr) {
            resultArray[count] = value;
            count--;
        }

        return resultArray;
    }
}
