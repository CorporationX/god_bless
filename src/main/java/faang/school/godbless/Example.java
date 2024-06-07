package faang.school.godbless;

public class Example {

    public void reverse(int[] array) {
        int beginPtr = 0;
        int endPtr = array.length - 1;
        while (beginPtr < endPtr) {
            swap(array, beginPtr, endPtr);
            beginPtr++;
            endPtr--;
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
