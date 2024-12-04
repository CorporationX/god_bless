package school.faang.sprint_1.task_43644;

public class Example {
    public static void revers(int[] numbers) {
        for (int i = 0; i < numbers.length / 2; i++) {
            int x = numbers[i];
            numbers[i] = numbers[numbers.length - i - 1];
            numbers[numbers.length - i - 1] = x;
        }
    }
}

/*
    Solution without hints

    public static int[] revers(int[] numbers) {
        int[] result = new int[numbers.length];
        int i = numbers.length - 1;
            for (int x = 0; x < numbers.length; x++) {
                result[x] = numbers[i];
                i--;
        }
        return result;
    }
*/