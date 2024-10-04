package school.faang.reversearray;

public class Example {
    public int[] reverse(int[] array) {

        if (array.length <= 1){
            return array;
        }

        var sPointer = 0;
        var ePointer = array.length - 1;

        while(sPointer <= ePointer) {
            var tmp = array[sPointer];
            array[sPointer] = array[ePointer];
            array[ePointer] = tmp;
            sPointer ++;
            ePointer --;
        }
        return array;
    }
}
