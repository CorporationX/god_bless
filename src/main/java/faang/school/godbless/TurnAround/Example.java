package faang.school.godbless.TurnAround;

public class Example {
    public static int[] reverse(int[] ints) throws IllegalArgumentException {
        if (ints == null) {
            throw new IllegalArgumentException("Массив не инициализирован");
        }
        if (ints.length <= 1) {
            return ints;
        }
        int j = ints.length - 1;
        int i = 0;
        while (i < j) {
            int temp = ints[i];
            ints[i] = ints[j];
            ints[j] = temp;
            i++;
            j--;
        }
        return ints;
    }
}
