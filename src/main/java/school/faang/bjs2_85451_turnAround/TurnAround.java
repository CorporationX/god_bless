package school.faang.bjs2_85451_turnAround;

public class TurnAround {
    public int[] reverse(int[] array) {
        int[] arrayReverse = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayReverse[array.length - 1 - i] = array[i];
        }
        return arrayReverse;
    }
}
