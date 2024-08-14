package faang.school.godbless.Task18963;



public class Example {

    public int[] reverse (int[] array){
        int left = 0;
        int right = array.length - 1;

            for (int i = 0; i <= right; i++) {
                while (left < right) {
                    int temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;
                    left++;
                    right--;
                }
            }
        return array;
    }
}
