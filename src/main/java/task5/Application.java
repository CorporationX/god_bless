package task5;

import java.util.ArrayList;


public class Application {
    public static void main(String... args) {
        var numbers = new ArrayList<Integer>();
        init(numbers);
        System.out.println(numbers);
        Example.reverse(numbers);
        System.out.println(numbers);
    }

    public static void init(ArrayList<Integer> numbers) {
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
    }


}
