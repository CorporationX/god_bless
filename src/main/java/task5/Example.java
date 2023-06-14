package task5;

import java.util.ArrayList;

public class Example {
    public static ArrayList<Integer> reverse(ArrayList<Integer> numbers) {
        int n = numbers.size() - 1;
        for (int i = 0; i < numbers.size() / 2; i++) {
            int temp = numbers.get(i);
            numbers.set(i, numbers.get(n - i));
            numbers.set(n - i, temp);
        }
        return numbers;
    }
}
