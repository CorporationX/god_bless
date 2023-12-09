package faang.school.godbless;

public class TurnAround {
    public int[] sort(int[] array){
        for(int i=0; i< array.length/2; i++) {
            int swap = array[i];
            array[i]=array[array.length-i-1];
            array[array.length-i-1]=swap;
        }

        return array;
    }

}
