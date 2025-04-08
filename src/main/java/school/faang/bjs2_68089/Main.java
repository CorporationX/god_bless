package school.faang.bjs2_68089;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        Example example = new Example();
        System.out.println("Original Array:");
        for (int element : array) {
            System.out.println(element);
        }
        System.out.println("=====================");
        example.reverseArray(array);
        System.out.println("Reverse Using for loop:");
        for (int element : array) {
            System.out.println(element);
        }
        System.out.println("=====================");
        example.reverseUsingList(array);
        System.out.println("Reversed using list:");
        for (int element : array) {
            System.out.println(element);
        }
    }
}