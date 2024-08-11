package faang.school.godbless.Task18963;



public class Example {

    public void reverse (int[] array){
        int length = array.length - 1;

        int[] massiv = new int[array.length];
        int result = massiv.length;

        for (int i = length; i >= 0; i--) {
            for (int j = 0; j < result; j++) {
                massiv[j] = array[i];
                i -= 1;
            }
        }
    }
}
