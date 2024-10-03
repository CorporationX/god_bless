package school.faang.reservearray;

public class Example {
    public int[] reserve(int[] array) {
        int[] reveredArray = new int[array.length];
        for(int i = 0; i < array.length; i++){
            reveredArray[i] = array[array.length - i - 1];
        }
        return reveredArray;
    }
}
