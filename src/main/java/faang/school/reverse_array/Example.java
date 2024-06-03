package faang.school.reverse_array;

public class Example {
    public static int[] reverse(int[] array){
        int[] result = new int[array.length];

        // Указатели на концы массива
        int startPointer = 0;
        int endPointer = array.length - 1;

        while(endPointer != -1){
            result[endPointer] = array[startPointer];
            startPointer++;
            endPointer--;
        }

        return result;
    }
}
