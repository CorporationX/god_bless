package faang.school.godbless;

public class Example {
    public static int[] reverse(int[] array){
        if (array==null){
            throw new NullPointerException("Array cannot be null");
        } else if (array.length==0 || array.length==1){
            return array;
        }
        int first = 0;
        int last = array.length-1;
        while (first<last){
            int pmp = array[last];
            array[last] = array[first];
            array[first] = pmp;
            first++;
            last--;
        }
        return array;
    }
}
