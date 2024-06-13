package faang.school.godbless;

public class Example {

    public int[] reverse(int[] reverse) {
        int[] result = new int[reverse.length];
        for (int i = reverse.length-1; i > 0; i--) {
            for (int j = 0; j < reverse.length; j++) {
                result[j] = reverse[i];
                i--;
            }
        }
        return result;
    }
}
