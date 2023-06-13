package faang.school.godbless.TurnAround;

public class Example {
    public static int[] reverse(int[] ints){
        int [] reversed = new int[ints.length];
        int j = 0;
        for (int i = ints.length-1; i > 0; i--){
            reversed[j++] = ints[i];
        }
        return reversed;
    }
}
