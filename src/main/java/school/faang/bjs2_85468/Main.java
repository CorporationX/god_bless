package school.faang.bjs2_85468;

public class Main {

    private static int[] arr = { 1, 2, 3, 4, 5 };

    public static void main(String[] args) {
        printArr(arr);
        Example exampleObj = new Example();
        arr = exampleObj.reverse(arr);
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int el : arr) {
            System.out.println(el);
        }
    }
}
