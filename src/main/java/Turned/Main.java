package Turned;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        for (int elem : array) {
            System.out.print(elem);
        }
        System.out.println();
        Example.reverse(array);
        for (int elem : array) {
            System.out.print(elem);
        }
    }
}
