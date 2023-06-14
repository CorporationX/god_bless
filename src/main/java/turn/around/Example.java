package turn.around;

public class Example {
    public static void reverse(int[] array) {
        int[] reverseArray = new int[array.length];
        int a = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            reverseArray[i] = array[a];
            a++;
        }
        for (int i = 0; i < reverseArray.length; i++) {
            System.out.print(reverseArray[i] + " ");
        }
        System.out.println();
    }

    public static void reverseArr(int[] array) {
        int start = 0;
        int end = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            int arrStart = array[start];
            array[start] = array[end];
            array[end] = arrStart;
            start++;
            end--;
            if (start == end) {
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        reverse(arr);
        reverseArr(arr);
    }
}
