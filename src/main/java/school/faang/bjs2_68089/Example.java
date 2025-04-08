package school.faang.bjs2_68089;

import java.util.ArrayList;

public class Example {

    public void reverse(int[] array) {
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    public void reverse2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    public void reverse3(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int j : array) {
            list.add(j);
        }
        list.sort((o1, o2) -> o2 - o1);
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        Example example = new Example();
        for (int j : array) {
            System.out.println(j);
        }
        System.out.println("=====================");
        example.reverse(array);
        for (int j : array) {
            System.out.println(j);
        }
        System.out.println("=====================");
        example.reverse2(array);
        for (int j : array) {
            System.out.println(j);
        }
        System.out.println("=====================");
        example.reverse3(array);
        for (int j : array) {
            System.out.println(j);
        }

    }
}
