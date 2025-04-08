package school.faang.bjs2_68089;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Original Array:");
        for (int element : array) {
            System.out.println(element);
        }
        System.out.println("=====================");
        Example example = new Example();
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
