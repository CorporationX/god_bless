package school.faang.sprint_1.task_bjs2n43622;

public class Example {
    public void reverse(int[] arr) {
        int first;
        int middleIndex = arr.length / 2;

        for (int i = 0; i < middleIndex; i++) {
            first = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = first;
        }
    }


}
