package school.faang.task_43627;

public class Main {

    public static void main(String[] args) {
        int[] evenExample = {5, 4, 3, 2, 1};
        printArray(evenExample);
        Example.reverse(evenExample);
        printArray(evenExample);

        int[] oddExample = {4, 3, 2, 1};
        printArray(oddExample);
        Example.reverse(oddExample);
        printArray(oddExample);
    }

    private static void printArray(int[] reverse) {
        for (int i : reverse) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
