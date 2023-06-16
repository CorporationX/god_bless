package faang.school.godbless.TurnAround;

public class Example {
    public static int[] reverse(int[] ints) throws IllegalArgumentException {
        if (ints == null || ints.length == 0){
            throw new IllegalArgumentException("Пустой массив");
        }
        if (ints.length == 1){
            return ints;
        }
        int j = ints.length-1;
        for (int i = 0; i <= j; i++){
            int temp = ints[i];
            ints[i] = ints[j];
            ints[j] = temp;
            j--;
        }
        return ints;
    }
}
