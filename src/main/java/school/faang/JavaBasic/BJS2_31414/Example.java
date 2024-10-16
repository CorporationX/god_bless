package school.faang.JavaBasic.BJS2_31414;

public class Example {
    public static int[] reverse(int[] array){
        int[] expandArray = array;
        for(int i = 0; i <= expandArray.length / 2; i++){
            int index = expandArray[i];
            expandArray[i] = expandArray[expandArray.length - i - 1];
            expandArray[expandArray.length - i - 1] = index;
        }
        return expandArray;
    }
}
