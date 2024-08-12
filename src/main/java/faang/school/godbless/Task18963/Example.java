package faang.school.godbless.Task18963;



public class Example {

    public int[] reverse (int[] array){
        int length = array.length;
        int[] result = new int[length];

            for (int i = 0; i < length; i++) {
                int index = length - 1 - i;
                result[i] = array[index];
            }
        return result;
    }
}
