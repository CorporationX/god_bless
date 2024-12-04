//https://faang-school.atlassian.net/browse/BJS2-43630
package derschrank2000.task01_BJS2_43630;

public class reverseArray{
    public static Object[] doReverse(Object[] array){
        int sizeOfArray = array.length;
        if (sizeOfArray < 2) return array;
        for(int i = 0; i < sizeOfArray / 2; i++){
            Object temp = array[i];
            array[i] = array[sizeOfArray - i - 1];
            array[sizeOfArray - i - 1] = temp;
        }
        return array;
    }
}
