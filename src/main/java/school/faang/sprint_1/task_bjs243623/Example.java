package school.faang.sprint_1.task_bjs243623;

public class Example {
    public static int[] reverse(int[] input) {
        if (input == null || input.length < 2) {
            return input;
        }

        int i = 0;
        int j = input.length - 1;
        int tmp;
        while (j - i >= 1) {
            tmp = input[i];
            input[i] = input[j];
            input[j] = tmp;
            i++;
            j--;
        }

        return input;
    }
}
