package school.faang.main_code_reverse;

public class Example {
    public static int[] reverse(int[] mas) {
        for (int i = 0; i < mas.length / 2; i++) {
            int temp = mas[i];
            mas[i] = mas[mas.length - i - 1];
            mas[mas.length - i - 1] = temp;
        }
        return mas;
    }
}